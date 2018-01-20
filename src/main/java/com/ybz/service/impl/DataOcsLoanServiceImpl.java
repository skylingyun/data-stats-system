package com.ybz.service.impl;

import com.ybz.dao.NodeLoanBillMapper;
import com.ybz.entity.NodeLoanBill;
import com.ybz.entity.NodeLoanBillExample;
import com.ybz.service.IDataOcsLoanService;
import com.ybz.utils.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 借还款单据实现类
 * Created by Guoru on 2017/8/3.
 */

@Service
public class DataOcsLoanServiceImpl implements IDataOcsLoanService {

    @Autowired
    private NodeLoanBillMapper nodeLoanBillMapperDao;

    public List<NodeLoanBill> getNodeLoanBillList(String currentTime){
        NodeLoanBillExample nodeLoanBillExample = new NodeLoanBillExample();
        nodeLoanBillExample.setDistinct(true);
        nodeLoanBillExample.setOrderByClause("ts desc");
        NodeLoanBillExample.Criteria criteria = nodeLoanBillExample.createCriteria();
        criteria.andValidEqualTo(true);
        if (currentTime != null) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd ");
                Date currentDate = simpleDateFormat.parse(currentTime);
                criteria.andTsGreaterThanOrEqualTo(currentDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return nodeLoanBillMapperDao.selectByExample(nodeLoanBillExample);
    }

    @Override
    public int countByExample(String beginTime, String endTime) {
        NodeLoanBillExample nodeLoanBillExample = new NodeLoanBillExample();
        nodeLoanBillExample.isDistinct();
        nodeLoanBillExample.setOrderByClause("ts desc");
        NodeLoanBillExample.Criteria criteria = nodeLoanBillExample.createCriteria();
        criteria.andValidEqualTo(true);
        if (StringUtils.isNotEmpty(beginTime) && StringUtils.isNotEmpty(endTime)) {
            Date beginDate = DateUtils.format(beginTime);
            Date endDate = DateUtils.format(endTime);
            criteria.andTsBetween(beginDate, endDate);
        }
        return nodeLoanBillMapperDao.countByExample(nodeLoanBillExample);
    }

    @Override
    public Double queryMoneyByDate(String beginTime, String endTime) {
        NodeLoanBillExample example = new NodeLoanBillExample();
        example.setDistinct(true);
        NodeLoanBillExample.Criteria criteria = example.createCriteria();
        criteria.andValidEqualTo(true);
        if(StringUtils.isNotEmpty(beginTime) && StringUtils.isNotEmpty(endTime)){
            Date beginDate = DateUtils.format(beginTime);
            Date endDate = DateUtils.format(endTime);
            criteria.andTsBetween(beginDate,endDate);
        }
        Double nodeLoanBillMoney = nodeLoanBillMapperDao.queryMoneyByDate(example);
        if(nodeLoanBillMoney == null){
            return 0.0;
        }
        return nodeLoanBillMoney;
    }
}
