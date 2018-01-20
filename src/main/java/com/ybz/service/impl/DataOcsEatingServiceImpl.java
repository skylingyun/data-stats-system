package com.ybz.service.impl;

import com.ybz.dao.NodeEatingMapper;
import com.ybz.dao.OcsEatingMapper;
import com.ybz.entity.NodeEating;
import com.ybz.entity.NodeEatingExample;
import com.ybz.entity.OcsEatingExample;
import com.ybz.service.IDataOcsEatingService;
import com.ybz.utils.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 餐饮实现类
 *
 * @author zhangybt
 * @create 2017年08月04日 16:17
 **/
@Service
public class DataOcsEatingServiceImpl implements IDataOcsEatingService {

    @Autowired
    private NodeEatingMapper nodeEatingMapperDao;

    @Autowired
    private OcsEatingMapper ocsEatingMapperDao;

    @Override
    public List<NodeEating> getNodeEatingList(String currentTime) {
        NodeEatingExample nodeEatingExample = new NodeEatingExample();
        nodeEatingExample.isDistinct();
        nodeEatingExample.setOrderByClause("ts desc");
        NodeEatingExample.Criteria criteria = nodeEatingExample.createCriteria();
        criteria.andValidEqualTo(true);
        if(StringUtils.isNotEmpty(currentTime)){
            Date currentDate =  DateUtils.format(currentTime);
            criteria.andTsGreaterThanOrEqualTo(currentDate);
        }
        return nodeEatingMapperDao.selectByExample(nodeEatingExample);
    }

    @Override
    public int countByExample(String beginTime,String endTime) {
        NodeEatingExample NodeEatingExample = new NodeEatingExample();
        NodeEatingExample.isDistinct();
        NodeEatingExample.setOrderByClause("ts desc");
        NodeEatingExample.Criteria criteria = NodeEatingExample.createCriteria();
        criteria.andValidEqualTo(true);
        if (StringUtils.isNotEmpty(beginTime)) {
            Date beginDate = DateUtils.format(beginTime);
            Date endDate = DateUtils.format(endTime);
            criteria.andTsBetween(beginDate,endDate);
        }
        return nodeEatingMapperDao.countByExample(NodeEatingExample);

    }

    @Override
    public Double queryMoneyByDate(String beginTime, String endTime) {
        NodeEatingExample nodeTravelExample = new NodeEatingExample();
        nodeTravelExample.setDistinct(true);
        NodeEatingExample.Criteria criteria = nodeTravelExample.createCriteria();
        criteria.andValidEqualTo(true);
        if(StringUtils.isNotEmpty(beginTime) && StringUtils.isNotEmpty(endTime)){
            Date beginDate = DateUtils.format(beginTime);
            Date endDate = DateUtils.format(endTime);
            criteria.andTsBetween(beginDate,endDate);
        }
        Double eatingMoney = nodeEatingMapperDao.queryMoneyByDate(nodeTravelExample);
        if(eatingMoney == null){
            return 0.0;
        }
        return eatingMoney;
    }

    @Override
    public int countByCondition(String tenantId, String countBeginDate, String countEndDate) {
        OcsEatingExample example = new OcsEatingExample();
        OcsEatingExample.Criteria criteria = example.createCriteria();
        criteria.andValidEqualTo(true);
        criteria.andTenantIdEqualTo(tenantId);
        if(StringUtils.isNotEmpty(countBeginDate) && StringUtils.isNotEmpty(countEndDate)){
            Date beginDate = DateUtils.format(countBeginDate);
            Date endDate = DateUtils.format(countEndDate);
            criteria.andEatingDateBetween(beginDate,endDate);
        }
        return ocsEatingMapperDao.countByExample(example);
    }

    @Override
    public Double queryMoneyByCondition(String tenantId, String countBeginDate, String countEndDate) {
        OcsEatingExample example = new OcsEatingExample();
        OcsEatingExample.Criteria criteria = example.createCriteria();
        criteria.andValidEqualTo(true);
        criteria.andTenantIdEqualTo(tenantId);
        if(StringUtils.isNotEmpty(countBeginDate) && StringUtils.isNotEmpty(countEndDate)){
            Date beginDate = DateUtils.format(countBeginDate);
            Date endDate = DateUtils.format(countEndDate);
            criteria.andEatingDateBetween(beginDate,endDate);
        }
        Double eatingMoney = ocsEatingMapperDao.queryMoneyByDate(example);
        if(eatingMoney == null){
            return 0.0;
        }
        return eatingMoney;
    }
}
