package com.ybz.service;


/**
 * Created by Administrator on 2017/12/3.
 */
public interface IDataOcsCommunicateService {

    int countByExample(String beginTime, String endTime);

    Double queryMoneyByDate(String beginTime,String endTime);

    int countByCondition(String tenantId, String countBeginDate, String countEndDate);

    Double queryMoneyByCondition(String tenantId, String countBeginDate, String countEndDate);

}
