package com.ybz.service;

import com.ybz.entity.UserVo;

import java.util.List;

/**
 * Created by Administrator on 2017/12/26.
 */
public interface IUserCenterService {

    List<UserVo> getUser(String tenantId);
}
