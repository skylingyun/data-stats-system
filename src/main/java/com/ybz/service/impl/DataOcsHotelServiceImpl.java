package com.ybz.service.impl;

import com.ybz.dao.NodeHotelMapper;
import com.ybz.dao.OcsHotelMapper;
import com.ybz.entity.NodeHotel;
import com.ybz.entity.NodeHotelExample;
import com.ybz.entity.OcsHotel;
import com.ybz.entity.OcsHotelExample;
import com.ybz.service.IDataOcsHotelService;
import com.ybz.utils.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 住宿记事实现类
 *
 * @author zhangybt
 * @create 2017年08月05日 10:14
 **/
@Service
public class DataOcsHotelServiceImpl implements IDataOcsHotelService {

    @Autowired
    private NodeHotelMapper nodeHotelMapperDao;

    @Autowired
    private OcsHotelMapper ocsHotelMapperDao;

    @Override
    public List<NodeHotel> getNodeHotelList(String currentTime, Integer pageSize, Integer currPage) {
        NodeHotelExample NodeHotelExample = new NodeHotelExample();
        NodeHotelExample.isDistinct();
        NodeHotelExample.setOrderByClause("ts desc");
        NodeHotelExample.setStartRow((currPage - 1) * pageSize);
        NodeHotelExample.setPageSize(pageSize);
        NodeHotelExample.Criteria criteria = NodeHotelExample.createCriteria();
        criteria.andValidEqualTo(true);
        if (StringUtils.isNotEmpty(currentTime)) {
            Date currentDate = DateUtils.format(currentTime);
            criteria.andTsGreaterThanOrEqualTo(currentDate);
        }
        List<NodeHotel> NodeHotelList = nodeHotelMapperDao.selectByExample(NodeHotelExample);
        return NodeHotelList;
    }

    @Override
    public int countByExample(String beginTime,String endTime) {
        NodeHotelExample NodeHotelExample = new NodeHotelExample();
        NodeHotelExample.isDistinct();
        NodeHotelExample.setOrderByClause("ts desc");
        NodeHotelExample.Criteria criteria = NodeHotelExample.createCriteria();
        criteria.andValidEqualTo(true);
        if (StringUtils.isNotEmpty(beginTime) && StringUtils.isNotEmpty(endTime)) {
            Date beginDate = DateUtils.format(beginTime);
            Date endDate = DateUtils.format(endTime);
            criteria.andTsBetween(beginDate,endDate);
        }
        return nodeHotelMapperDao.countByExample(NodeHotelExample);

    }

    @Override
    public Double queryMoneyByDate(String beginTime, String endTime) {
        NodeHotelExample nodeTravelExample = new NodeHotelExample();
        nodeTravelExample.setDistinct(true);
        NodeHotelExample.Criteria criteria = nodeTravelExample.createCriteria();
        criteria.andValidEqualTo(true);
        if(StringUtils.isNotEmpty(beginTime) && StringUtils.isNotEmpty(endTime)){
            Date beginDate = DateUtils.format(beginTime);
            Date endDate = DateUtils.format(endTime);
            criteria.andTsBetween(beginDate,endDate);
        }
        Double hotelMoney = nodeHotelMapperDao.queryMoneyByDate(nodeTravelExample);
        if(hotelMoney == null){
            return 0.0;
        }
        return hotelMoney;
    }

    @Override
    public int countByCondition(String tenantId, String countBeginDate, String countEndDate) {
        OcsHotelExample example = new OcsHotelExample();
        example.setOrderByClause("ts desc");
        OcsHotelExample.Criteria criteria = example.createCriteria();
        criteria.andValidEqualTo(true);
        criteria.andTenantIdEqualTo(tenantId);
        if (StringUtils.isNotEmpty(countBeginDate) && StringUtils.isNotEmpty(countEndDate)) {
            Date beginDate = DateUtils.format(countBeginDate);
            Date endDate = DateUtils.format(countEndDate);
            criteria.andTsBetween(beginDate,endDate);
        }
        return ocsHotelMapperDao.countByExample(example);
    }

    @Override
    public Double queryMoneyByCondition(String tenantId, String countBeginDate, String countEndDate) {
        OcsHotelExample example = new OcsHotelExample();
        example.setOrderByClause("ts desc");
        OcsHotelExample.Criteria criteria = example.createCriteria();
        criteria.andValidEqualTo(true);
        criteria.andTenantIdEqualTo(tenantId);
        if (StringUtils.isNotEmpty(countBeginDate) && StringUtils.isNotEmpty(countEndDate)) {
            Date beginDate = DateUtils.format(countBeginDate);
            Date endDate = DateUtils.format(countEndDate);
            criteria.andTsBetween(beginDate,endDate);
        }
        Double hotelMoney = ocsHotelMapperDao.queryMoneyByDate(example);
        if(hotelMoney == null){
            return 0.0;
        }
        return hotelMoney;
    }
}
