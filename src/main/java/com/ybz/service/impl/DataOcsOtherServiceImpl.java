package com.ybz.service.impl;

import com.ybz.dao.NodeOtherMapper;
import com.ybz.dao.OcsOtherMapper;
import com.ybz.entity.NodeOther;
import com.ybz.entity.NodeOtherExample;
import com.ybz.entity.OcsOtherExample;
import com.ybz.service.IDataOcsOtherService;
import com.ybz.utils.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 其它记事实现类
 *
 * @author zhangybt
 * @create 2017年08月05日 9:31
 **/
@Service
public class DataOcsOtherServiceImpl implements IDataOcsOtherService {

    @Autowired
    private NodeOtherMapper nodeOtherMapperDao;

    @Autowired
    private OcsOtherMapper ocsOtherMapperDao;

    @Override
    public List<NodeOther> getOtherList(String currentTime) {
        NodeOtherExample nodeOtherExample = new NodeOtherExample();
        nodeOtherExample.isDistinct();
        nodeOtherExample.setOrderByClause("ts desc");
        NodeOtherExample.Criteria criteria = nodeOtherExample.createCriteria();
        criteria.andValidEqualTo(true);
        if (StringUtils.isNotEmpty(currentTime)) {
            Date currentDate = DateUtils.format(currentTime);
            criteria.andTsGreaterThanOrEqualTo(currentDate);
        }
        return nodeOtherMapperDao.selectByExample(nodeOtherExample);
    }


    /**
     * 根据时间查询数量
     *
     * @param beginTime
     * @param endTime
     * @return
     */
    @Override
    public int countByExample(String beginTime, String endTime) {
        NodeOtherExample NodeOtherExample = new NodeOtherExample();
        NodeOtherExample.isDistinct();
        NodeOtherExample.setOrderByClause("ts desc");
        NodeOtherExample.Criteria criteria = NodeOtherExample.createCriteria();
        criteria.andValidEqualTo(true);
        if (StringUtils.isNotEmpty(beginTime) && StringUtils.isNotEmpty(endTime)) {
            Date beginData = DateUtils.format(beginTime);
            Date endData = DateUtils.format(endTime);
            criteria.andTsBetween(beginData, endData);
        }
        return nodeOtherMapperDao.countByExample(NodeOtherExample);

    }

    /**
     * 根据时间查询金额
     *
     * @param beginTime
     * @param endTime
     * @return
     */
    @Override
    public Double queryMoneyByDate(String beginTime, String endTime) {
        NodeOtherExample nodeTravelExample = new NodeOtherExample();
        nodeTravelExample.setDistinct(true);
        NodeOtherExample.Criteria criteria = nodeTravelExample.createCriteria();
        criteria.andValidEqualTo(true);
        if (StringUtils.isNotEmpty(beginTime) && StringUtils.isNotEmpty(endTime)) {
            Date beginDate = DateUtils.format(beginTime);
            Date endDate = DateUtils.format(endTime);
            criteria.andTsBetween(beginDate, endDate);
        }
        Double otherMoney = nodeOtherMapperDao.queryMoneyByDate(nodeTravelExample);
        if (otherMoney == null) {
            return 0.0;
        }
        return otherMoney;
    }

    @Override
    public int countByCondition(String tenantId, String countBeginDate, String countEndDate) {
        OcsOtherExample ocsOtherExample = new OcsOtherExample();
        ocsOtherExample.setOrderByClause("ts desc");
        OcsOtherExample.Criteria criteria = ocsOtherExample.createCriteria();
        criteria.andValidEqualTo(true);
        criteria.andTenantIdEqualTo(tenantId);
        if (StringUtils.isNotEmpty(countBeginDate) && StringUtils.isNotEmpty(countEndDate)) {
            Date beginData = DateUtils.format(countBeginDate);
            Date endData = DateUtils.format(countEndDate);
            criteria.andOtherDateBetween(beginData, endData);
        }
        return ocsOtherMapperDao.countByExample(ocsOtherExample);
    }

    @Override
    public Double queryMoneyByCondition(String tenantId, String countBeginDate, String countEndDate) {
        OcsOtherExample otherExample = new OcsOtherExample();
        OcsOtherExample.Criteria criteria = otherExample.createCriteria();
        criteria.andValidEqualTo(true);
        criteria.andTenantIdEqualTo(tenantId);
        if (StringUtils.isNotEmpty(countBeginDate) && StringUtils.isNotEmpty(countEndDate)) {
            Date beginDate = DateUtils.format(countBeginDate);
            Date endDate = DateUtils.format(countEndDate);
            criteria.andOtherDateBetween(beginDate, endDate);
        }
        Double otherMoney = ocsOtherMapperDao.queryMoneyByDate(otherExample);
        if (otherMoney == null) {
            return 0.0;
        }
        return otherMoney;
    }
}
