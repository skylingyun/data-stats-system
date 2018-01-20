package com.ybz.service;

import com.ybz.entity.Tenant;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/1/3.
 */
public interface IDataUserService {
    List<Tenant> selectTenantDetail(Date startTime, Date endTime) throws Exception;

    List<String> getDataBaseList() throws Exception;
}
