package com.ybz.service;

import com.ybz.entity.NodeBusinessTrip;

import java.util.List;

/**
 * 申请单据接口
 * Created by Guoru on 2017/8/3.
 */
public interface IDataOcsApplyService {
    List<NodeBusinessTrip> getNodeBusinessTripList(String currentTime);

    int countByExample(String beginTime, String endTime);

    Double queryMoneyByDate(String beginTime, String endTime);
}
