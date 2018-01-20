package com.ybz.service.impl;

import com.ybz.dao.UserVoMapper;
import com.ybz.entity.UserVo;
import com.ybz.service.IUserCenterService;
import com.yonyou.iuap.tenant.sdk.UserCenter;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/26.
 */
@Service
public class UserCenterServiceImpl implements IUserCenterService{

    @Autowired
    private UserVoMapper userVoMapper;

    @Override
    public List<UserVo> getUser(String tenantId) {
        List<UserVo> userVoList = new ArrayList<UserVo>();
        JSONObject jsonObject = JSONObject.fromObject(UserCenter.getUserList(tenantId,"1","1",null));
        int totalElements = Integer.parseInt(JSONObject.fromObject(jsonObject.opt("users")).optString("totalElements"));
        int pageSize = 100;
        int pageNum = totalElements/pageSize;
        for (int i = 1; i <= pageNum; i++) {
            JSONObject userCenters = JSONObject.fromObject(UserCenter.getUserList(tenantId,pageSize+"",i+"",null));
            JSONArray content = JSONArray.fromObject(JSONObject.fromObject(userCenters.opt("users")).opt("content"));
            for (int j = 0; j < content.size() ; j++) {
                UserVo userVo = (UserVo) JSONObject.toBean(JSONObject.fromObject(content.get(j)),UserVo.class);
                userVo.setTenantId(tenantId);
                userVoList.add(userVo);
                if(userVoList.size() == 50){
                   int count = userVoMapper.insertUserVoBatch(userVoList);
                   userVoList.clear();
                }
            }
        }
        if(userVoList.size() != 0){
            int count = userVoMapper.insertUserVoBatch(userVoList);
        }
        return userVoList;
    }
}
