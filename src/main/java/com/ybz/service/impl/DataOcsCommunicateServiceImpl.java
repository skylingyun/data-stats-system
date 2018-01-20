package com.ybz.service.impl;

import com.ybz.dao.NodeCommunicateMapper;
import com.ybz.entity.NodeCommunicateExample;
import com.ybz.service.IDataOcsCommunicateService;
import com.ybz.utils.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2017/12/3.
 */
@Service
public class DataOcsCommunicateServiceImpl implements IDataOcsCommunicateService {
    @Autowired
    private NodeCommunicateMapper nodeCommunicateMapper;
    @Override
    public int countByExample(String beginTime, String endTime) {
        NodeCommunicateExample example = new NodeCommunicateExample();
        example.setDistinct(true);
        example.setOrderByClause("ts desc");
        NodeCommunicateExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(beginTime) && StringUtils.isNotEmpty(endTime)) {
            Date beginDate = DateUtils.format(beginTime);
            Date endDate = DateUtils.format(endTime);
            criteria.andCommunicateDateBetween(beginDate, endDate);
        }
        return nodeCommunicateMapper.countByExample(example);
    }

    @Override
    public Double queryMoneyByDate(String beginTime, String endTime) {
        NodeCommunicateExample example = new NodeCommunicateExample();
        example.setDistinct(true);
        example.setOrderByClause("ts desc");
        NodeCommunicateExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(beginTime) && StringUtils.isNotEmpty(endTime)) {
            Date beginDate = DateUtils.format(beginTime);
            Date endDate = DateUtils.format(endTime);
            criteria.andCommunicateDateBetween(beginDate, endDate);
        }
        Double communicateMoney = nodeCommunicateMapper.queryMoneyByDate(example);
        if(communicateMoney == null){
            return 0.0;
        }
        return communicateMoney;
    }
}
