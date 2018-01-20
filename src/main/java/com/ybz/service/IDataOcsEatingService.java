package com.ybz.service;

import com.ybz.entity.NodeEating;

import java.util.List;

/**
 * 餐饮接口
 *
 * @author zhangybt
 * @create 2017年08月04日 10:18
 **/
public interface IDataOcsEatingService {

    List<NodeEating> getNodeEatingList(String currentTime);

    int countByExample(String beginTime,String endTime);

    Double queryMoneyByDate(String beginTime,String endTime);

    int countByCondition(String tenantId, String countBeginDate, String countEndDate);

    Double queryMoneyByCondition(String tenantId, String countBeginDate, String countEndDate);
}
