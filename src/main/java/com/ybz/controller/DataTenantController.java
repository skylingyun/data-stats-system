package com.ybz.controller;

import com.ybz.dao.UserMapper;
import com.ybz.entity.Tenant;
import com.ybz.entity.TenantUserRelation;
import com.ybz.entity.User;
import com.ybz.service.IDataTenantService;
import com.ybz.thread.DataTenantThread;
import com.ybz.thread.ThreadPoolExecutorFactory;
import com.ybz.utils.*;
import com.yonyou.iuap.context.InvocationInfoProxy;
import com.yonyou.iuap.tenant.sdk.TenantCenter;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * 友互通和应用中心数据信息
 **/
@RestController
@RequestMapping("/tenant")
public class DataTenantController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Resource(name = "dataTenantServiceImpl")
    private IDataTenantService dataTenantService;
    @Autowired
    private UserMapper userMapperDao;
    private static LoggerHelper logger = new LoggerHelper(DataTenantController.class);

    /**
     * 根据手机号查询用户所属租户列表
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/getTenantListByMobile", method = RequestMethod.POST)
    public DataResult getTenantListByUserMobile(@RequestBody Map<String, String> map) {
        try {
            String userMobile = map.get("userMobile");
            return DataResult.ok().put("data", dataTenantService.getTenantListByUserMobile(userMobile));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return DataResult.error().put("data", e.getMessage());
        }
    }

    /**
     * 根据租户ID获取租户信息
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/queryTenantInfoByTenantId", method = RequestMethod.POST)
    public DataResult getTenantInfoByTenantId(@RequestBody Map<String, String> map) {
        try {
            String tenantName = map.get("tenantName");
            return DataResult.ok().put("data", dataTenantService.getTenantInfoByTenantName(tenantName));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return DataResult.error().put("data", e.getMessage());
        }
    }

    /**
     * 获取所有的租户信息
     *
     * @return
     */
    @RequestMapping(value = "/queryTenantInfoList", method = RequestMethod.POST)
    public DataResult queryTenantInfoList(@RequestBody Map<String, String> map) {
        try {
            int offset = Integer.parseInt(map.get("activePage"));
            int limit = Integer.parseInt(map.get("totalPage"));
            List<Tenant> tenantList = dataTenantService.getTenants(offset, limit);
            int count = DataBaseUtils.queryDataBasesCountFromExcel();
            return DataResult.ok().put("data", new PageUtils(tenantList, count, limit, offset));
        } catch (Exception e) {
            logger.error(e.getMessage());
            return DataResult.error().put("data", e.getMessage());
        }


    }

    /**
     * 解除用户和租户关系(单个)
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/deleteSingleRelation", method = RequestMethod.POST)
    public DataResult deleteSingleRelation(@RequestBody Map<String, String> map) {
        try {
            JSONObject removeResult = dataTenantService.deleteSingleRelation(map.get("userMobile"), map.get("tenantId"));
            return DataResult.ok().put("data", removeResult.optString("msg"));
        } catch (Exception e) {
            logger.error("单个用户和租户关系删除失败", e.getMessage());
            return DataResult.error().put("data", e.getMessage());
        }
    }

    /**
     * 解除用户和租户关系(批量)
     *
     * @param tenantId
     * @param phone
     * @return
     */
    @RequestMapping(value = "/batchDeleteRelation", method = RequestMethod.POST)
    public DataResult deleteRelation(String tenantId, String[] phone) {
        try {
            List<String> removeList = dataTenantService.deleteRelationBatch(tenantId, phone);
            return DataResult.ok().put("msg", removeList);
        } catch (Exception e) {
            logger.error("批量删除用户租户关系失败", e.getMessage());
            return DataResult.error().put("data", e.getMessage());
        }
    }

    /**
     * 添加关联关系
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/addToTenant", method = RequestMethod.POST)
    public DataResult addToTenant(@RequestBody Map<String, String> map) {
        try {
            JSONObject addRelation = dataTenantService.addRelationshipForUser(map.get("userMobile"), map.get("tenantId"));
            if("0".equalsIgnoreCase(addRelation.optString("code"))){
                return DataResult.error(addRelation.optString("msg"));
            }
            return DataResult.ok().put("data", addRelation.optString("msg"));
        } catch (Exception e) {
            logger.error("为用户添加关联关系失败", e.getMessage());
            return DataResult.error().put("data", e.getMessage());
        }
    }

    @RequestMapping(value = "/getDataBasesList", method = RequestMethod.POST)
    public DataResult getDataBasesList() {
        try {
            return DataResult.ok().put("data", dataTenantService.getDataBasesList());
        } catch (Exception e) {
            logger.error("查询租户失败", e.getMessage());
            return DataResult.error().put("data", e.getMessage());
        }
    }

    @RequestMapping(value = "/queryUserListByValid", method = RequestMethod.POST)
    public DataResult queryUserListByValid(@RequestBody Map<String, String> map) {
        InvocationInfoProxy.setTenantid(map.get("tenantId"));
        List<User> userList = dataTenantService.queryUserListByValid(map);
        int userCount = dataTenantService.countByValid(map);
        PageUtils pageUtils = new PageUtils(userList, userCount, Integer.parseInt(map.get("totalPage")), Integer.parseInt(map.get("activePage")));
        return DataResult.ok().put("data", pageUtils);
    }

    /**
     * 将友互通的用户租户关系同步到本地库
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/updateTenantUserRelation", method = RequestMethod.POST)
    public DataResult updateTenantUserRelation(@RequestBody Map<String, String> map) {
        try {
            InvocationInfoProxy.setTenantid(map.get("tenantId"));
            int total = dataTenantService.updateTenantUserRelation(map.get("tenantId"), Integer.parseInt(map.get("activePage")), Integer.parseInt(map.get("totalPage")));
            return DataResult.ok().put("data", total);
        } catch (Exception e) {
            logger.error("用户同步失败", e.getMessage());
            return DataResult.error(-1, e.getMessage());
        }
    }

    @RequestMapping(value = "/queryTenantUserRelation", method = RequestMethod.POST)
    public DataResult queryTenantUserRelation(@RequestBody Map<String, String> map) {
        try {
            String tenantId = map.get("tenantId");
            InvocationInfoProxy.setTenantid(tenantId);
            List<TenantUserRelation> tenantUserRelationList = dataTenantService.queryTenantUserRelation(tenantId, Integer.parseInt(map.get("activePage")), Integer.parseInt(map.get("totalPage")));
            int count = dataTenantService.count();
            return DataResult.ok().put("data", new PageUtils(tenantUserRelationList, count, Integer.parseInt(map.get("totalPage")), Integer.parseInt(map.get("activePage"))));
        } catch (Exception e) {
            logger.error("租户关系查询失败", e.getMessage());
            return DataResult.error().put("data", e.getMessage());
        }
    }

    /**
     * 解除用户和租户关系(单个)
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/deleteTenantInfoSingleRelation", method = RequestMethod.POST)
    public DataResult deleteTenantInfoSingleRelation(@RequestBody Map<String, String> map) {
        try {
            String tenantId = map.get("tenantId");
            return DataResult.ok().put("data", dataTenantService.deleteRelationshipForTenant(tenantId));
        } catch (Exception e) {
            logger.error("为租户删除关系失败", e.getMessage());
            return DataResult.error().put("data", e.getMessage());
        }
    }

    /**
     * 手动添加新的租户到租户列表集合中
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/addNewTenant", method = RequestMethod.POST)
    public DataResult addNewTenant(@RequestBody Map<String, String> map) throws Exception {
        String tenantId = map.get("tenantId");
        try {
            //验证通过后再添加
            dataTenantService.addNewTenant(tenantId);
            return DataResult.ok().put("data", "新增成功");
        } catch (Exception e) {
            logger.error("新增租户列表失败", e.getMessage());
            return DataResult.error().put("data", e.getMessage());
        }

    }

    /**
     * 创造用户活跃度
     *
     * @return
     */
    @RequestMapping(value = "/addActiveUser", method = RequestMethod.POST)
    public DataResult addActiveUser(@RequestBody Map<String,String> params) throws Exception {
        try {
            dataTenantService.addActiveUser(params);
            return DataResult.ok().put("data", "添加用户活跃度成功");
        } catch (Exception e) {
            logger.error("添加用户活跃度失败", e.getMessage());
            return DataResult.error().put("data", e.getMessage());
        }
    }

    /**
     * 创造用户活跃度
     *
     * @return
     */
    @RequestMapping(value = "/checkTenantIdExist", method = RequestMethod.POST)
    public DataResult checkTenantIdExist() throws Exception {
        try {
            dataTenantService.checkTenantIdExist();
            return DataResult.ok().put("data", "添加用户活跃度成功");
        } catch (Exception e) {
            logger.error("添加用户活跃度失败", e.getMessage());
            return DataResult.error().put("data", e.getMessage());
        }
    }
}
