package com.ybz.service.impl;

import com.ybz.dao.*;
import com.ybz.entity.*;
import com.ybz.service.IDataUserService;
import com.ybz.utils.ArithUtils;
import com.ybz.utils.DataBaseUtils;
import com.ybz.utils.DateUtils;
import com.ybz.utils.LoggerHelper;
import com.yonyou.iuap.context.InvocationInfoProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/1/3.
 */
@Service
public class DataUserServiceImpl implements IDataUserService {
    private static LoggerHelper logger = new LoggerHelper(DataUserServiceImpl.class);

    @Autowired
    private SysTenantMapper sysTenantMapperDao;

    @Autowired
    private OcsUserMapper ocsUserMapperDao;

    @Autowired
    private OcsExpenseMapper ocsExpenseMapperDao;

    @Autowired
    private OcsApplyMapper ocsApplyMapperDao;

    @Autowired
    private OcsLoanMapper ocsLoanMapperDao;

    @Autowired
    private OcsPaymentMapper ocsPaymentMapperDao;

    @Autowired
    private OcsEatingMapper ocsEatingMapperDao;

    @Autowired
    private OcsTravelMapper ocsTravelMapperDao;

    @Autowired
    private OcsHotelMapper ocsHotelMapperDao;

    @Autowired
    private OcsCommunicateMapper ocsCommunicateMapperDao;

    @Autowired
    private OcsOtherMapper ocsOtherMapperDao;

    @Autowired
    private NcInfoMapper ncInfoMapper;

    @Override
    public List<Tenant> selectTenantDetail(Date startDate, Date endDate) throws Exception {
        List<Tenant> tenantList = new ArrayList<Tenant>();
        List<SysTenant> sysTenantList = sysTenantMapperDao.selectByExample(new SysTenantExample());
        for (SysTenant sysTenant : sysTenantList) {
            String tenantId = sysTenant.getTenantId();
            Tenant tenant = new Tenant();
            //1.租户名称
            tenant.setTenantName(sysTenant.getTenantName());
            //2.租户ID
            tenant.setTenantId(tenantId);
            //3.租户开通时间
            tenant.setCreateTime(DateUtils.format(sysTenant.getCreateTime()));
            //4.开通总人数
            OcsUserExample ocsUserExample = new OcsUserExample();
            OcsUserExample.Criteria ocsUserExampleCriteria = ocsUserExample.createCriteria();
            ocsUserExampleCriteria.andRegisterdateBetween(startDate,endDate);
            ocsUserExampleCriteria.andTenantIdEqualTo(tenantId);
            int totalUserCount = ocsUserMapperDao.countByExample(ocsUserExample);
            tenant.setUserCount(totalUserCount);
            //5.报销人数
            OcsExpenseExample ocsExpenseExample = new OcsExpenseExample();
            OcsExpenseExample.Criteria ocsExpenseExampleCriteria = ocsExpenseExample.createCriteria();
            ocsExpenseExampleCriteria.andExpenseDateBetween(startDate,endDate);
            ocsExpenseExampleCriteria.andTenantIdEqualTo(tenantId);
            int reimburseNo = ocsExpenseMapperDao.distinctUserIdCount(ocsExpenseExample);
            tenant.setReimburseTotalCount(reimburseNo);
            //报销人有效值
            ocsExpenseExampleCriteria.andValidEqualTo(true);
            tenant.setReimburseCount(ocsExpenseMapperDao.distinctUserIdCount(ocsExpenseExample));
            //6.报销占比
            tenant.setReimburseProportion(ArithUtils.div((double)reimburseNo,(double)totalUserCount));
            //7.单据总数量
            //报销单
            OcsExpenseExample expenseExample = new OcsExpenseExample();
            OcsExpenseExample.Criteria expenseCriteria = expenseExample.createCriteria();
            expenseCriteria.andExpenseDateBetween(startDate,endDate);
            expenseCriteria.andTenantIdEqualTo(tenantId);
            int totalExpenseCount = ocsExpenseMapperDao.countByExample(expenseExample);
            tenant.setExpenseCount(totalExpenseCount);
            expenseCriteria.andValidEqualTo(true);
            int expenseCount = ocsExpenseMapperDao.countByExample(expenseExample);
            expenseCriteria.andBillstatusEqualTo(5);
            int expenseApprove = ocsExpenseMapperDao.countByExample(expenseExample);
            //申请单
            OcsApplyExample ocsApplyExample = new OcsApplyExample();
            OcsApplyExample.Criteria ocsApplyExampleCriteria = ocsApplyExample.createCriteria();
            ocsApplyExampleCriteria.andDealdateBetween(startDate,endDate);
            ocsApplyExampleCriteria.andTenantIdEqualTo(tenantId);
            int totalTripCount = ocsApplyMapperDao.countByExample(ocsApplyExample);
            ocsApplyExampleCriteria.andValidEqualTo(true);
            int tripCount = ocsApplyMapperDao.countByExample(ocsApplyExample);
            ocsApplyExampleCriteria.andBillstatusEqualTo(5);
            int tripApprove = ocsApplyMapperDao.countByExample(ocsApplyExample);
            //借款单
            OcsLoanExample ocsLoanExample = new OcsLoanExample();
            OcsLoanExample.Criteria loanCriteria = ocsLoanExample.createCriteria();
            loanCriteria.andDealdateBetween(startDate,endDate);
            loanCriteria.andTenantIdEqualTo(tenantId);
            int totalLoanCount = ocsLoanMapperDao.countByExample(ocsLoanExample);
            loanCriteria.andValidEqualTo(true);
            int loanCount = ocsLoanMapperDao.countByExample(ocsLoanExample);
            loanCriteria.andBillstatusEqualTo(5);
            int loanApprove = ocsLoanMapperDao.countByExample(ocsLoanExample);
            //还款单
            OcsPaymentExample ocsPaymentExample = new OcsPaymentExample();
            OcsPaymentExample.Criteria payCriteria = ocsPaymentExample.createCriteria();
            payCriteria.andDealdateBetween(startDate,endDate);
            payCriteria.andTenantIdEqualTo(tenantId);
            int totalPayCount = ocsPaymentMapperDao.countByExample(ocsPaymentExample);
            payCriteria.andValidEqualTo(true);
            int paymentCount = ocsPaymentMapperDao.countByExample(ocsPaymentExample);
            payCriteria.andBillstatusEqualTo(5);
            int paymentApprove = ocsPaymentMapperDao.countByExample(ocsPaymentExample);
            tenant.setBillCount(expenseCount + tripCount + loanCount + paymentCount);
            tenant.setTotalBillCount(totalExpenseCount+totalLoanCount+totalPayCount+totalTripCount);
            //8.单据总金额
            OcsExpenseExample exampleExpense = new OcsExpenseExample();
            OcsExpenseExample.Criteria criteriaExpense = exampleExpense.createCriteria();
            criteriaExpense.andDealdateBetween(startDate,endDate);
            criteriaExpense.andTenantIdEqualTo(tenantId);
            criteriaExpense.andValidEqualTo(true);
            Double expenseMoney = ocsExpenseMapperDao.queryMoneyByDate(exampleExpense) == null ? 0.0 : ocsExpenseMapperDao.queryMoneyByDate(exampleExpense) ;

            OcsApplyExample exampleTrip = new OcsApplyExample();
            OcsApplyExample.Criteria criteriaTrip = exampleTrip.createCriteria();
            criteriaTrip.andValidEqualTo(true);
            criteriaTrip.andDealdateBetween(startDate,endDate);
            criteriaTrip.andTenantIdEqualTo(tenantId);
            Double tripMoney = ocsApplyMapperDao.queryMoneyByDate(exampleTrip) == null ? 0.0 : ocsApplyMapperDao.queryMoneyByDate(exampleTrip);

            OcsLoanExample exampleLoan = new OcsLoanExample();
            OcsLoanExample.Criteria criteriaLoan = exampleLoan.createCriteria();
            criteriaLoan.andValidEqualTo(true);
            criteriaLoan.andDealdateBetween(startDate,endDate);
            criteriaLoan.andTenantIdEqualTo(tenantId);
            Double loanMoney = ocsLoanMapperDao.queryMoneyByDate(exampleLoan) == null ? 0.0 : ocsLoanMapperDao.queryMoneyByDate(exampleLoan);

            OcsPaymentExample examplePay = new OcsPaymentExample();
            OcsPaymentExample.Criteria criteriaPay = examplePay.createCriteria();
            criteriaPay.andDealdateBetween(startDate,endDate);
            criteriaPay.andValidEqualTo(true);
            criteriaPay.andTenantIdEqualTo(tenantId);
            Double paymentMoney = ocsPaymentMapperDao.queryMoneyByDate(examplePay) == null ? 0.0 : ocsPaymentMapperDao.queryMoneyByDate(examplePay);
            Double billOneMoney = ArithUtils.add(expenseMoney,tripMoney);
            Double billTwoMoney = ArithUtils.add(loanMoney,paymentMoney);
            Double money =  ArithUtils.add(billOneMoney,billTwoMoney);
            tenant.setBillMoney(money);
            //9.人均单据量
            tenant.setPersonProportion(ArithUtils.div((double)tenant.getTotalBillCount(),(double)reimburseNo));
            //10.审批总数
            tenant.setApproveCount(expenseApprove + tripApprove + loanApprove + paymentApprove);
            //11.记账总数
            OcsEatingExample eatingExample = new OcsEatingExample();
            OcsEatingExample.Criteria criteriaEating = eatingExample.createCriteria();
            criteriaEating.andEatingDateBetween(startDate,endDate);
            criteriaEating.andTenantIdEqualTo(tenantId);
            int eatingCount = ocsEatingMapperDao.countByExample(eatingExample);

            OcsTravelExample travelExample = new OcsTravelExample();
            OcsTravelExample.Criteria criteriaTravel = travelExample.createCriteria();
            criteriaTravel.andTravelDateBetween(startDate,endDate);
            criteriaTravel.andTenantIdEqualTo(tenantId);
            int travelCount = ocsTravelMapperDao.countByExample(travelExample);

            OcsHotelExample hotelExample = new OcsHotelExample();
            OcsHotelExample.Criteria criteriaHotel = hotelExample.createCriteria();
            criteriaHotel.andStartDateGreaterThan(startDate);
            criteriaHotel.andEndDateLessThan(endDate);
            criteriaHotel.andTenantIdEqualTo(tenantId);
            int hotelCount = ocsHotelMapperDao.countByExample(hotelExample);

            OcsOtherExample otherExample = new OcsOtherExample();
            OcsOtherExample.Criteria criteriaOther = otherExample.createCriteria();
            criteriaOther.andOtherDateBetween(startDate,endDate);
            criteriaOther.andTenantIdEqualTo(tenantId);
            int otherCount = ocsOtherMapperDao.countByExample(otherExample);

            OcsCommunicateExample communicateExample = new OcsCommunicateExample();
            OcsCommunicateExample.Criteria criteriaCommunicate = communicateExample.createCriteria();
            criteriaCommunicate.andCommunicateDateBetween(startDate,endDate);
            criteriaCommunicate.andTenantIdEqualTo(tenantId);
            int communicateCount = ocsCommunicateMapperDao.countByExample(communicateExample);
            tenant.setNoteCount(eatingCount + travelCount + hotelCount + otherCount + communicateCount);
            tenantList.add(tenant);
        }
        return tenantList;
    }

    @Override
    public List<String> getDataBaseList() throws Exception {
        List<String> ncTenantIdList = null;
        try {
            List<String> list = DataBaseUtils.queryDataBasesList();
            ncTenantIdList = new ArrayList<String>();
            for (String tenantId : list) {
                if(tenantId.length() != 8){
                    continue;
                }
                InvocationInfoProxy.setTenantid(tenantId);
                if(ncInfoMapper.selectOsType()==null){
                    continue;
                }
                if("nc".equalsIgnoreCase(ncInfoMapper.selectOsType().getOstype())){
                    ncTenantIdList.add(tenantId);
                    System.out.println("属于NC的租户ID是："+tenantId);
                }else {
                    continue;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ncTenantIdList;
    }

}
