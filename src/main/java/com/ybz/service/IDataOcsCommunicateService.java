package com.ybz.service;

import com.ybz.entity.NodeCommunicateExample;

/**
 * Created by Administrator on 2017/12/3.
 */
public interface IDataOcsCommunicateService {

    int countByExample(String beginTime, String endTime);

    Double queryMoneyByDate(String beginTime,String endTime);

}
