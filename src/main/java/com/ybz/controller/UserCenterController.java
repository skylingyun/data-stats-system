package com.ybz.controller;

import com.ybz.entity.UserVo;
import com.ybz.service.IUserCenterService;
import com.ybz.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangybt on 2017/12/26.
 */
@RestController
@RequestMapping("/center")
public class UserCenterController {

    @Autowired
    private IUserCenterService userCenterService;

    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    public DataResult getUser(@RequestBody Map<String,String> params){
        List<UserVo> userVoList = userCenterService.getUser(params.get("tenantId"));
        return DataResult.ok().put("data",userVoList);
    }
}
