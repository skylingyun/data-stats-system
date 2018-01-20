package com.ybz.service.impl;

import com.ybz.dao.NcInfoMapper;
import com.ybz.dao.NcUserMapper;
import com.ybz.dao.TenantUserRelationMapper;
import com.ybz.dao.UserMapper;
import com.ybz.entity.*;
import com.ybz.exception.CustomBusinessException;
import com.ybz.exception.CustomRuntimeException;
import com.ybz.service.IDataTenantService;
import com.ybz.thread.DataTenantThread;
import com.ybz.thread.ThreadPoolExecutorFactory;
import com.ybz.utils.*;
import com.yonyou.iuap.context.InvocationInfoProxy;
import com.yonyou.iuap.tenant.sdk.TenantCenter;
import com.yonyou.iuap.tenant.sdk.UserCenter;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 用户和租户实现类
 *
 * @author zhangybt
 * @create 2017年08月02日 13:37
 **/
@Service
public class DataTenantServiceImpl implements IDataTenantService {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserMapper userMapperDao;
    @Autowired
    private NcUserMapper ncUserMapperDao;
    @Autowired
    private TenantUserRelationMapper tenantUserRelationMapper;
    @Autowired
    private NcInfoMapper ncInfoMapperDao;
    private Map<String, String> tenantIdAndNameMap = new HashMap<String, String>();
    private static LoggerHelper logger = new LoggerHelper(DataTenantServiceImpl.class);

    @Override
    public List<Object> getTenantListByUserMobile(String userMobile) throws Exception {
        if (StringUtils.isEmpty(userMobile)) {
            throw new CustomBusinessException("手机号为空");
        }
        List<Object> resultList = new LinkedList<Object>();
        //调用应用中心接口查询用户信息
        String userId = TenantUserUtil.getTenantUserIdByPhone(userMobile);
        if (StringUtils.isEmpty(userId)) {
            throw new CustomBusinessException("友互通中没有找到对应的用户,请检查手机号是否正确!");
        }
        //根据用户信息查询租户信息
        JSONObject tenant = JSONObject.fromObject(TenantCenter.findTenantsByUserId(userId));
        JSONArray data = JSONArray.fromObject(tenant.get("data"));
        List<Tenant> localTenants = queryTenantInfoList(1, DataBaseUtils.queryDataBasesCountFromExcel());
        Set<String> localTenantSet = new HashSet<String>();
        if (localTenants != null && localTenants.size() > 0) {
            for (Tenant t : localTenants) {
                localTenantSet.add(t.getTenantId());
            }
        }
        if (localTenants == null) {
            throw new CustomBusinessException("获取本地租户列表失败!");
        }
        for (int i = 0; i < data.size(); i++) {
            JSONObject tenantList = JSONObject.fromObject(data.get(i));
            Tenant tenantInfo = new Tenant();
            tenantInfo.setTenantId(tenantList.optString("tenantId"));
            tenantInfo.setTenantName(tenantList.optString("tenantName"));
            tenantInfo.setTenantAddress(tenantList.optString("tenantAddress"));
            tenantInfo.setTenantEmail(tenantList.optString("tenantEmail"));
            tenantInfo.setTenantFullname(tenantList.optString("tenantFullname"));
            tenantInfo.setTenantTel(tenantList.optString("tenantTel"));
            //判断如果是我们的租户，则添加标记，前台会根据这个标记决定是否显示“删除关系”
            if (DataBaseUtils.queryDataBasesListFromExcel(0, 1000).contains(tenantInfo.getTenantId())) {
                tenantInfo.setIsLocal("是");
            } else {
                tenantInfo.setIsLocal("否");
            }
            resultList.add(tenantInfo);
        }
        return resultList;
    }

    @Override
    public List<Tenant> getTenantInfoByTenantName(String tenantName) throws Exception {
        Tenant tenant = new Tenant();
        List<Tenant> tenantList = new LinkedList<Tenant>();
        JSONObject tenantInfoJson = new JSONObject();
        //先根据租户名称匹配租户id，再查询租户信息
        if (tenantIdAndNameMap.containsValue(tenantName)) {
            for (String tenantId : tenantIdAndNameMap.keySet()) {
                if (tenantIdAndNameMap.get(tenantId).equals(tenantName)) {
                    tenantInfoJson = JSONObject.fromObject(TenantCenter.getTenantById(tenantId));
                    break;
                }
            }
        } else {
            return queryTenantInfoList(1, 20);
        }
        if (tenantInfoJson.size() == 0) {
            logger.error("用户中心无此租户");
            throw new CustomBusinessException("用户中心无此租户");
        }
        if (tenantInfoJson.containsKey("status") && "1".equals(tenantInfoJson.optString("status"))) {
            if (tenantInfoJson.optJSONObject("tenant") == null) {
                logger.error("用户中心无此租户");
                throw new CustomBusinessException("用户中心无此租户");
            }
            //设置租户对象信息
            JSONObject tenantInfo = tenantInfoJson.optJSONObject("tenant");
            tenant.setTenantId(tenantInfo.optString("tenantId"));
            tenant.setTenantName(tenantInfo.optString("tenantName"));
            tenant.setTenantAddress(tenantInfo.optString("tenantAddress"));
            tenant.setTenantEmail(tenantInfo.optString("tenantEmail"));
            tenant.setTenantFullname(tenantInfo.optString("tenantFullname"));
            tenant.setTenantTel(tenantInfo.optString("tenantTel"));
            String tenantId = tenantInfo.optString("tenantId");
            InvocationInfoProxy.setTenantid(tenantId);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String createTime = sdf.format(userMapperDao.queryCreateTime(tenantId));
            tenant.setCreateTime(createTime);
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andDrEqualTo(false);
            int userCount = userMapperDao.countByValid(example);
            tenant.setUserNum(String.valueOf(userCount));
            tenantList.add(tenant);
            return tenantList;
        } else {
            throw new CustomBusinessException("查询租户信息失败");
        }
    }

    @Override
    public DataResult getUserByPhone(String tenantId, String userMobile) {
        InvocationInfoProxy.setTenantid(tenantId);
        Map<String, String> addParams = new HashMap<String, String>();
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneEqualTo(userMobile);
        criteria.andDrEqualTo(false);
        userExample.setDistinct(true);
        userExample.setOrderByClause("ts desc");
        List<User> userList = userMapperDao.selectByExample(userExample);
        if (userList.size() == 0) {
            return DataResult.error().put("data", "没有查询到此用户");
        }
        User user = userList.get(0);
        addParams.put("tenantId", tenantId);
        // todo 用户中心userCode有唯一校验，添加关系时可能报错，因此添加了随机数区分。
        addParams.put("userCode", user.getUserCode());
        addParams.put("userName", user.getUserName());
        addParams.put("userMobile", user.getPhone());
        addParams.put("userEmail", user.getEmail());
        addParams.put("systemId", TenantUserUtil.systemId);
        addParams.put("userPassword", TenantUserUtil.password);
        com.alibaba.fastjson.JSONObject userJson = new com.alibaba.fastjson.JSONObject();
        JSONArray userJsonArray = new JSONArray();
        userJsonArray.add(addParams);
        userJson.put("users", userJsonArray);
        try {
            JSONObject addUserAndRelations = JSONObject.fromObject(UserCenter.addUsersAndRelations(tenantId, TenantUserUtil.systemId, null, "111111", userJson.toJSONString()));
            //用户中心添加过程
            if (addUserAndRelations.has("status") && addUserAndRelations.optInt("status") == 1) {
                return DataResult.ok().put("msg", addUserAndRelations.optString("msg"));
            }
        } catch (JSONException e) {
            logger.error("用户中心添加用户失败", e.getMessage());
            throw new CustomRuntimeException("用户中心添加用户失败");
        }
        return null;
    }

    @Override
    public List<User> queryUserListByValid(Map<String, String> map) {
        int userValid = 0, ncUserValid = 0;
        if (StringUtils.isNotEmpty(map.get("validCode")) && StringUtils.equalsIgnoreCase("true", map.get("validCode"))) {
            userValid = 0;
            ncUserValid = 1;
        } else {
            userValid = 1;
            ncUserValid = 0;
        }
        List<String> list = queryUserIdByValid(map.get("beginTime"), map.get("endTime"));
        UserExample example = new UserExample();
        example.setDistinct(true);
        example.setOrderByClause("ts desc");
        example.setPageSize(Integer.parseInt(map.get("activePage")));
        example.setStartRow(Integer.parseInt(map.get("totalPage")));
        UserExample.Criteria criteria = example.createCriteria();
        if (userValid == 0) {
            criteria.andDrEqualTo(false);
        }
        criteria.andUseridIn(list);
        List<User> userList = userMapperDao.queryUserListByValid(example);
        return userList;
    }

    private List<String> queryUserIdByValid(String beginTime, String endTime) {
        List<String> list = new LinkedList<String>();
        NcUserExample ncUserExample = new NcUserExample();
        ncUserExample.setDistinct(true);
        NcUserExample.Criteria nCriteria = ncUserExample.createCriteria();
        nCriteria.andValidEqualTo(true);
        if (StringUtils.isNotEmpty(beginTime) && StringUtils.isNotEmpty(endTime)) {
            Date beginDate = DateUtils.format(beginTime);
            Date endDate = DateUtils.format(endTime);
            nCriteria.andTsBetween(beginDate, endDate);
        }
        List<NcUser> ncUserList = ncUserMapperDao.selectByExample(ncUserExample);
        for (NcUser ncUser : ncUserList) {
            list.add(ncUser.getUserid());
        }
        return list;
    }

    @Override
    public int countByValid(Map<String, String> map) {
        int userValid = 0, ncUserValid = 0;
        if (StringUtils.isNotEmpty(map.get("validCode")) && StringUtils.equalsIgnoreCase("true", map.get("validCode"))) {
            userValid = 0;
            ncUserValid = 1;
        } else {
            userValid = 1;
            ncUserValid = 0;
        }
        String beginTime = map.get("beginTime");
        String endTime = map.get("endTime");
        List<String> list = queryUserIdByValid(beginTime, endTime);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andDrEqualTo(false);
        if (StringUtils.isNotEmpty(beginTime) && StringUtils.isNotEmpty(endTime)) {
            Date beginDate = DateUtils.format(beginTime);
            Date endDate = DateUtils.format(endTime);
            criteria.andTsBetween(beginDate, endDate);
        }
        criteria.andUseridIn(list);
        int userCount = userMapperDao.countByValid(example);
        return userCount;
    }

    /**
     * 同步租户用户关系
     *
     * @param tenantId
     * @param offset
     * @param limit
     * @return
     */
    @Override
    public int updateTenantUserRelation(String tenantId, int offset, int limit) throws Exception {
        InvocationInfoProxy.setTenantid(tenantId);
        int countTotal = 1;
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andDrEqualTo(false);//dr为0即用户有效
        List<User> userList = userMapperDao.selectByExample(example);//查询tenantId对应库中所有的有效用户
        TenantUserRelationExample tenantUserRelationExample = new TenantUserRelationExample();
        tenantUserRelationMapper.deleteByExample(tenantUserRelationExample);
        String userId = "";
        for (User user : userList) {
            //根据用户手机号从用户中心查询租户关系
            JSONObject userJsonObject = JSONObject.fromObject(UserCenter.getUserByLoginName(user.getPhone()));
            if (userJsonObject == null || userJsonObject.isNullObject()) {
                logger.error("用户中心无此租户");
                continue;
            }
            if (!"1".equals(userJsonObject.get("status").toString())) {
                logger.error("用户中心无此租户");
                continue;
            }
            JSONObject userInfo = JSONObject.fromObject(userJsonObject.get("user"));
            if (!userInfo.containsKey("userId")) {
                logger.error("用户中心无此租户");
                continue;
            }
            userId = userInfo.getString("userId");
            JSONObject tenant = JSONObject.fromObject(TenantCenter.findTenantsByUserId(userId));
            JSONArray data = JSONArray.fromObject(tenant.get("data"));
            //先删除后批量插入
            TenantUserRelation tenantUserRelation = new TenantUserRelation();
            for (int i = 0; i < data.size(); i++) {
                JSONObject tenantIds = JSONObject.fromObject(data.get(i));
                tenantUserRelation.setMobile(user.getPhone());
                tenantUserRelation.setTenantName(tenantIds.get("tenantName").toString());
                tenantUserRelation.setDeptName(user.getDeptname());
                tenantUserRelation.setCompany(user.getCompany());
                tenantUserRelation.setTenantId(tenantIds.get("tenantId").toString());
                int count = tenantUserRelationMapper.insert(tenantUserRelation);
                System.out.println(count + "*****" + countTotal++);
            }
        }
        return countTotal;
    }

    @Override
    public int count() {
        TenantUserRelationExample tenantUserRelationExample = new TenantUserRelationExample();
        return tenantUserRelationMapper.countByExample(tenantUserRelationExample);
    }

    @Override
    public List<TenantUserRelation> queryTenantUserRelation(String tenantId, int offset, int limit) throws Exception {
        List<TenantUserRelation> relationList = new ArrayList<TenantUserRelation>();
        TenantUserRelationExample tenantUserRelationExample = new TenantUserRelationExample();
        tenantUserRelationExample.setPageSize(limit);
        tenantUserRelationExample.setStartRow(offset);
        relationList = tenantUserRelationMapper.selectByExample(tenantUserRelationExample);
        return relationList;
    }

    public void addNewTenant(String tenantId) throws Exception {
        //验证有效性
        //验证是否有效8位
        if (tenantId.length() != 8) {
            logger.error("无效的租户ID");
            throw new CustomBusinessException("无效的租户ID");
        }
        //验证Excel租户列表中存不存在
        List<String> dataBasesList = DataBaseUtils.queryDataBasesListFromExcel(1, DataBaseUtils.queryDataBasesCountFromExcel());
        if (dataBasesList.contains(tenantId)) {
            logger.error("租户已经存在");
            throw new CustomBusinessException("租户已经存在");
        }
        //验证友互通存不存在
        JSONObject tenantInfoJson = JSONObject.fromObject(TenantCenter.getTenantById(tenantId));
        if (tenantInfoJson.size() == 0) {
            logger.error("用户中心无此租户");
            throw new CustomBusinessException("用户中心无此租户");
        }
        if (tenantInfoJson.containsKey("status") && "1".equals(tenantInfoJson.optString("status"))) {
            if (tenantInfoJson.optJSONObject("tenant") == null) {
                logger.error("用户中心无此租户");
                throw new CustomBusinessException("用户中心无此租户");
            }
        }
        //写入Excel
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet();
        ExportExcel exportExcel = new ExportExcel(wb, sheet);
        dataBasesList.add(tenantId);
        Collections.sort(dataBasesList);
        //创建单元格
        for (int i = 0; i < dataBasesList.size(); i++) {
            XSSFRow row = sheet.createRow((short) (i));
            for (int j = 0; j < 1; j++) {
                exportExcel
                        .cteateCell(wb, row, (short) j,
                                HSSFCellStyle.ALIGN_LEFT, dataBasesList.get(i));
            }

        }
        try {
            Properties props = Resources.getResourceAsProperties("sdk.properties");
            String filePath = props.getProperty("databases.excel.path");
            exportExcel.outputExcel(filePath);
            wb.close();
        } catch (IOException e) {
            logger.error("添加租户ID时文件流操作失败", e.getMessage());
            throw new CustomRuntimeException("文件流操作失败");
        }
    }

    @Override
    public List<Tenant> queryTenantInfoList(int offset, int limit) throws Exception {
        return this.getTenants(offset, limit);
    }

    @Override
    public List<Tenant> getTenants(int offset, int limit) throws Exception {
        List<Tenant> tenantList = new ArrayList<Tenant>();//返回List
        //读取redis缓存
//        String key = "tenantList:" + String.valueOf(offset);
//        Object tenantListObject = RedisTemplateUtil.getFromList(key);
//        if (tenantListObject == null) {
        tenantList = new LinkedList<Tenant>();
        List<String> list = DataBaseUtils.queryDataBasesListFromExcel(offset, limit);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String createTime = "";
        for (int i = 0; i < list.size(); i++) {
            //非法租户
            if (list.get(i).length() != 8) {
                logger.error("非法租户");
                continue;
            }
            JSONObject tenantInfoJson = JSONObject.fromObject(TenantCenter.getTenantById(list.get(i)));
            if (tenantInfoJson.size() == 0) {
                logger.error("用户中心无此租户");
                continue;
            }
            if (tenantInfoJson.containsKey("status") && "1".equals(tenantInfoJson.optString("status"))) {
                if (tenantInfoJson.optJSONObject("tenant") == null) {
                    logger.error("用户中心无此租户");
                    continue;
                }
                JSONObject tenantInfo = tenantInfoJson.optJSONObject("tenant");
                Tenant tenant = new Tenant();
                tenant.setTenantId(tenantInfo.optString("tenantId"));
                tenant.setTenantName(tenantInfo.optString("tenantName"));
                tenant.setTenantAddress(tenantInfo.optString("tenantAddress"));
                tenant.setTenantEmail(tenantInfo.optString("tenantEmail"));
                tenant.setTenantFullname(tenantInfo.optString("tenantFullname"));
                tenant.setTenantTel(tenantInfo.optString("tenantTel"));
                InvocationInfoProxy.setTenantid(list.get(i));
                createTime = sdf.format(userMapperDao.queryCreateTime(list.get(i)));//获取数据库创建时间，这里以user_t表的创建时间
                tenant.setCreateTime(createTime);
                UserExample example = new UserExample();
                UserExample.Criteria criteria = example.createCriteria();
                criteria.andDrEqualTo(false);
                int userCount = userMapperDao.countByValid(example);
                tenant.setUserNum(String.valueOf(userCount));
                tenantList.add(tenant);
            }
        }
        String currPage = "tenantList:" + String.valueOf(offset);
        RedisTemplateUtil.setToList(currPage, tenantList, 10000L);
//        } else {
//            ThreadPoolExecutorFactory.getParallelPoolExecutor().execute(new DataTenantThread(offset, limit, this));
//            if (tenantListObject instanceof LinkedList<?>) {
//                tenantList = (LinkedList<Tenant>) tenantListObject;
//            }
//        }
        return tenantList;
    }

    @Override
    public JSONObject deleteSingleRelation(String userMobile, String tenantId) throws Exception {
        String userId = TenantUserUtil.getTenantUserIdByPhone(userMobile);
        JSONObject removeResult = JSONObject.fromObject(UserCenter.removeFromTenant(tenantId, new String[]{userId}));
        return removeResult;
    }

    @Override
    public List<String> deleteRelationBatch(String tenantId, String[] phone) throws Exception {
        List<String> removeList = new ArrayList<String>();
        for (String userMobile : phone) {
            String userId = TenantUserUtil.getTenantUserIdByPhone(userMobile);
            JSONObject removeResult = JSONObject.fromObject(UserCenter.removeFromTenant(tenantId, new String[]{userId}));
            if (removeResult.containsKey("status") && "1".equals(removeResult.optString("status"))) {
                removeList.add(removeResult.optString("msg"));
            }
        }
        return removeList;
    }

    @Override
    public JSONObject addRelationshipForUser(String userMobile, String tenantId) throws Exception {
        JSONObject addUserAndRelation = new JSONObject();
        //遍历map中的键
        for (Map.Entry<String, String> entry : tenantIdAndNameMap.entrySet()) {
            if (tenantId.equalsIgnoreCase(entry.getValue())) {
                InvocationInfoProxy.setTenantid(entry.getKey());
                break;
            }
            continue;
        }
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andDrEqualTo(false);
        criteria.andPhoneEqualTo(userMobile);
        List<User> users = userMapperDao.selectByExample(userExample);
        if (users.size() == 1) {
            for (User user : users) {
                Map<String, String> userMap = new HashMap<String, String>();
                userMap.put("tenantId", InvocationInfoProxy.getTenantid());
//                userMap.put("userCode", user.getUserCode());
                userMap.put("userName", user.getUserName());
                userMap.put("userMobile", user.getPhone());
                if (!org.springframework.util.StringUtils.isEmpty(user.getEmail())) {
                    userMap.put("userEmail", user.getEmail());
                }
                userMap.put("systemId", TenantUserUtil.systemId);
                userMap.put("userPassword", TenantUserUtil.password);


//                com.alibaba.fastjson.JSONObject userJsonObject = new com.alibaba.fastjson.JSONObject();
//                JSONArray userJsonArray = new JSONArray();
//                userJsonArray.add(userMap);
//                userJsonObject.put("users", userJsonArray);
//                org.json.JSONObject userCenterInfo = new org.json.JSONObject(UserCenter.addUsersAndRelations(InvocationInfoProxy.getTenantid(), TenantUserUtil.systemId, null, userMap.get("userCode"), userJsonObject.toJSONString()));
//                addUserAndRelation = JSONObject.fromObject(userCenterInfo);

                addUserAndRelation = JSONObject.fromObject(UserCenter.addUserAndRelation(userMap));
                //用户中心添加过程
                if (addUserAndRelation.has("status") && addUserAndRelation.optInt("status") == 1) {
                    return addUserAndRelation;
                } else {
                    userMap.remove("userCode");
                    addUserAndRelation = JSONObject.fromObject(UserCenter.addUserAndRelation(userMap));
                    return addUserAndRelation;
                }
            }
        } else {
            JSONObject jsonObject = JSONObject.fromObject(UserCenter.getUserByLoginName(userMobile));
            if (jsonObject.containsKey("user")) {
                JSONObject userInfo = JSONObject.fromObject(jsonObject.optString("user"));
                if (userInfo.size() != 0) {
                    String userId = userInfo.optString("userId");
                    if (StringUtils.isNotEmpty(userId)) {
                        JSONObject addToTenant = JSONObject.fromObject(UserCenter.addToTenant(InvocationInfoProxy.getTenantid(), TenantUserUtil.userType, new String[]{userId}));
                        return addToTenant;
                    }
                } else {
                    addUserAndRelation.put("msg", jsonObject.optString("msg"));
                    addUserAndRelation.put("code", "0");
                    return addUserAndRelation;
                }
            } else {
                addUserAndRelation.put("msg", "友互通查询不到此人");
                addUserAndRelation.put("code", "0");
                return addUserAndRelation;
            }

        }
        addUserAndRelation.put("msg", tenantId + "库中不存在此手机号！");
        addUserAndRelation.put("code", "0");
        return addUserAndRelation;
    }

    /**
     * 获取租户列表
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<Map<String, String>> getDataBasesList() throws Exception {
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        Map<String, String> tenantMap = null;
        Map<String, String> tenantItemMap = new HashMap<String, String>();
        tenantItemMap.put(0 + "", "请选择租户");
        result.add(tenantItemMap);
//        String key = "tenantIdAndName";
//        Map<String, String> tenantListObject = RedisTemplateUtil.getFromMap(key);
//        int count = 1;
//        if (tenantListObject.size() != 0) {
//            for (Map.Entry<String, String> entry : tenantIdAndNameMap.entrySet()) {
//                tenantItemMap = new HashMap<String, String>();
//                tenantItemMap.put(count + "", entry.getValue());
//                result.add(tenantItemMap);
//                count++;
//            }
//            return result;
//        } else {
        //查询租户列表
        List<String> list = DataBaseUtils.queryDataBasesListFromExcel(1, DataBaseUtils.queryDataBasesCountFromExcel());
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                tenantMap = new HashMap<String, String>();
                //查询租户信息
                JSONObject tenantInfoJson = JSONObject.fromObject(TenantCenter.getTenantById(list.get(i)));
                if (tenantInfoJson.size() == 0) {
                    logger.error("用户中心无此租户: " + list.get(i));
                    continue;
                }
                //设置该租户的显示项
                if (tenantInfoJson.containsKey("status") && "1".equals(tenantInfoJson.optString("status"))) {
                    if (tenantInfoJson.optJSONObject("tenant") == null) {
                        logger.error("用户中心无此租户: " + list.get(i));
                        continue;
                    }
                    JSONObject tenantInfo = tenantInfoJson.optJSONObject("tenant");
                    tenantMap.put((i + 1) + "", tenantInfo.optString("tenantName"));
                    tenantIdAndNameMap.put(list.get(i), tenantInfo.optString("tenantName"));//选择租户名称后查租户信息时需要这个map
                    RedisTemplateUtil.setToMap("tenantIdAndName", tenantIdAndNameMap, 10000L);
                    result.add(tenantMap);
                }
            }
        }
//        }
        return result;
    }

    @Override
    public List<String> deleteRelationshipForTenant(String tenantId) throws Exception {
        List<String> removeList = new ArrayList<String>();
        JSONObject tenantAdminByTenantId = JSONObject.fromObject(UserCenter.getTenantAdminByTenantId(tenantId));
        if (tenantAdminByTenantId.containsKey("tenantUsers")) {
            JSONArray tenantAdmin = tenantAdminByTenantId.optJSONArray("tenantUsers");
            for (int i = 0; i < tenantAdmin.size(); i++) {
                JSONObject tenant = tenantAdmin.optJSONObject(i);
                if (tenant.containsKey("userId")) {
                    JSONObject removeResult = JSONObject.fromObject(UserCenter.removeFromTenant(tenantId, new String[]{tenant.optString("userId")}));
                    if (removeResult.containsKey("status") && "1".equals(removeResult.optString("status"))) {
                        removeList.add(removeResult.optString("msg"));
                    }
                }
            }
        }
        return removeList;
    }

    @Override
    public List<User> queryUserMobileByCreateTime() {
        UserExample example = new UserExample();
        example.setDistinct(true);
        example.setOrderByClause("ts desc");
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andDrEqualTo(false);
        criteria.andAssociationGreaterThan("2017-10-09");
        List<User> userList = userMapperDao.queryUserMobileByCreateTime(example);
        return userList;
    }

    @Override
    public void addActiveUser(Map<String, String> params) throws Exception {
        List<String> ncList = new ArrayList<String>();
        List<String> otherList = new ArrayList<String>();
        List<Integer> ncCountList = new ArrayList<Integer>();
        List<Integer> otherCountList = new ArrayList<Integer>();
        //调用添加活跃度的接口
        String url = "https://data.yonyoucloud.com/yst/uploadLogin.do";
        //查询Excel中的租户（判断redis是否存在）
//        String key = "tenantIdAndName";
        List<String> list = DataBaseUtils.queryDataBasesListFromExcel(1, DataBaseUtils.queryDataBasesCountFromExcel());
//        Map<String, String> tenantListObject = RedisTemplateUtil.getFromMap(key);
//        if (tenantListObject.size() != 0) {
//            for (Map.Entry<String, String> entry : tenantIdAndNameMap.entrySet()) {
//                list.add(entry.getKey());
//            }
//        }else {
//            list = DataBaseUtils.queryDataBasesListFromExcel(1, DataBaseUtils.queryDataBasesCountFromExcel());
//        }
        try {
            List<Map<String, String>> users = new ArrayList<Map<String, String>>();
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    InvocationInfoProxy.setTenantid(list.get(i));
                    NcInfo ncInfo = ncInfoMapperDao.selectOsType();
                    if ("nc".equals(ncInfo.getOstype())) {
                        UserExample userExample = new UserExample();
                        UserExample.Criteria criteria = userExample.createCriteria();
                        criteria.andDrEqualTo(false);
                        List<User> userList = userMapperDao.selectByExample(userExample);
                        ncCountList.add(userList.size());
                        for (User user : userList) {
//                            Map<String, String> map = new HashMap<String, String>();
                            String userId = TenantUserUtil.getTenantUserIdByPhone(user.getPhone());
                            if (StringUtils.isEmpty(userId) || StringUtils.isBlank(userId)) {
                                continue;
                            }
                            user.setUserid(userId);
//                            map.put("userId", userId);
//                            map.put("mobile",user.getPhone());
//                            map.put("tenantId",list.get(i));
//                            users.add(map);
                            com.alibaba.fastjson.JSONObject param = createParamsMethod(user,params,list.get(i));
                            HttpClientUtil httpClientUtil = new HttpClientUtil();
                            String result = httpClientUtil.doPost(url, param);
                            System.out.println(result);
                        }
                        ncList.add(list.get(i));
                        System.out.println(users);
                    } else {
                        UserExample userExample = new UserExample();
                        UserExample.Criteria criteria = userExample.createCriteria();
                        criteria.andDrEqualTo(false);
                        List<User> userList = userMapperDao.selectByExample(userExample);
                        otherCountList.add(userList.size());
                        for (User user : userList) {
                            com.alibaba.fastjson.JSONObject param = createParamsMethod(user, params,list.get(i));
                            HttpClientUtil httpClientUtil = new HttpClientUtil();
                            String result = httpClientUtil.doPost(url, param);
                            System.out.println(result);
                        }
                        otherList.add(list.get(i));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Nc租户:" + ncList);
        System.out.println("其它租户:" + otherList);
        System.out.println("Nc租户总人数:" + ncCountList);
        System.out.println("其它租户总人数:" + otherCountList);
    }

    private com.alibaba.fastjson.JSONObject createParamsMethod(User user, Map<String, String> params,String tenantId) {
        com.alibaba.fastjson.JSONObject param = new com.alibaba.fastjson.JSONObject();
        param.put("clientid", "yyyoubz");
        param.put("clientsecret", "28e980o5b2d693651bc9dc01h28a6cvx6");
        param.put("systag", "yyyoubz");
        param.put("userid", user.getUserid());
        param.put("corporationid", tenantId);
        param.put("username", user.getUserName());
        if (StringUtils.isNotEmpty(params.get("startDate")) && StringUtils.isNotEmpty(params.get("endDate"))) {
            Date date = DateUtils.randomDate(params.get("startDate"), params.get("endDate"));
            String dateFormat = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
            param.put("loginTime", dateFormat);//yyyyMMddHHmmss
        } else {
            Date date = DateUtils.randomDate("2018-01-01", "2018-02-01");
            String dateFormat = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
            param.put("loginTime", dateFormat);//yyyyMMddHHmmss
        }
        param.put("mobile", "2");
        return param;
    }

    @Override
    public void checkTenantIdExist() throws Exception {
        List<String> tenantIdList = new ArrayList<String>();
        List<String> list = DataBaseUtils.queryDataBasesListFromExcel(1, DataBaseUtils.queryDataBasesCountFromExcel());
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                InvocationInfoProxy.setTenantid(list.get(i));
                NcInfoExample ncInfoExample = new NcInfoExample();
                List<NcInfo> ncInfoList = ncInfoMapperDao.selectByExample(ncInfoExample);
                tenantIdList.add(list.get(i));
            }
        }
        System.out.println(tenantIdList);
    }
}
