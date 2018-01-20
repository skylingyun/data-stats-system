package com.ybz.task;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.ybz.dao.NodeLoanBillMapper;
import com.yonyou.common.utils.DateUtils;
import com.yonyou.common.utils.TenantUtils;
import com.yonyou.iuap.context.InvocationInfoProxy;
import com.yonyou.modules.base.entity.NodeBusinessTrip;
import com.yonyou.modules.base.entity.NodeExpense;
import com.yonyou.modules.base.entity.NodeLoanbill;
import com.yonyou.modules.base.entity.NodePayment;
import com.yonyou.modules.base.service.INodeBusinessTripService;
import com.yonyou.modules.base.service.INodeExpenseService;
import com.yonyou.modules.base.service.INodeLoanbillService;
import com.yonyou.modules.base.service.INodePaymentService;
import com.yonyou.modules.basic.entity.OcsApply;
import com.yonyou.modules.basic.entity.OcsExpense;
import com.yonyou.modules.basic.entity.OcsLoan;
import com.yonyou.modules.basic.entity.OcsPayment;
import com.yonyou.modules.basic.service.IOcsApplyService;
import com.yonyou.modules.basic.service.IOcsExpenseService;
import com.yonyou.modules.basic.service.IOcsLoanService;
import com.yonyou.modules.basic.service.IOcsPaymentService;
import com.yonyou.modules.system.entity.SysTenant;
import com.yonyou.modules.system.service.ISysTenantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/1/17.
 */
@Component("mergeBills")
public class MergeBills {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ISysTenantService sysTenantService;

    //-------------------单据(begin)--------------------
    //报销单(旧)
    @Autowired
    private INodeExpenseService nodeExpenseService;
    //报销单(新)
    @Autowired
    private IOcsExpenseService ocsExpenseService;
    //申请单(旧)
    @Autowired
    private INodeBusinessTripService nodeBusinessTripService;
    //申请单(新)
    @Autowired
    private IOcsApplyService ocsApplyService;
    //借款单(旧)
    @Autowired
    private NodeLoanBillMapper nodeLoanbillService;
    //借款单(新)
    @Autowired
    private IOcsLoanService ocsLoanService;
    //还款单(旧)
    @Autowired
    private INodePaymentService nodePaymentService;
    //还款单(新)
    @Autowired
    private IOcsPaymentService ocsPaymentService;
    //-------------------单据(end)----------------------

    /**
     * 整合单据数据
     */

    public void mergeBills() {
        logger.info("我是带参数的mergeBills方法，正在被执行");
        try {
            Thread.sleep(1000L);
            List<SysTenant> sysTenantList = sysTenantService.selectList(new EntityWrapper<>());
            for (SysTenant sysTenant : sysTenantList) {
                String tenantId = sysTenant.getTenantId();
                //报销单据
                List<OcsExpense> ocsExpenseList = new ArrayList<>();
                if (ocsExpenseService.selectCount(new EntityWrapper<OcsExpense>().eq(OcsExpense.TENANT_ID, tenantId)) == 0) {
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<NodeExpense> nodeExpenseList = nodeExpenseService.selectList(new EntityWrapper<>());
                    if (CollectionUtils.isNotEmpty(nodeExpenseList)) {
                        ocsExpenseList.clear();
                        for (NodeExpense nodeExpense : nodeExpenseList) {
                            OcsExpense ocsExpense = getOcsExpense(tenantId, nodeExpense);
                            ocsExpenseList.add(ocsExpense);
                        }
                    }
                } else {
                    //目标中存在数据
                    InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                    String startDate = ocsExpenseService.selectMaxDate();
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<NodeExpense> nodeExpenseList = nodeExpenseService.selectList(new EntityWrapper<NodeExpense>().between(NodeExpense.TS, startDate, DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN)));
                    if (CollectionUtils.isNotEmpty(nodeExpenseList)) {
                        InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                        ocsExpenseList.clear();
                        for (NodeExpense nodeExpense : nodeExpenseList) {
                            if (ocsExpenseService.selectList(new EntityWrapper<OcsExpense>().eq(OcsExpense.PK, nodeExpense.getPk())).size() == 0) {
                                OcsExpense ocsExpense = getOcsExpense(tenantId, nodeExpense);
                                ocsExpenseList.add(ocsExpense);
                            } else {
                                InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                                OcsExpense ocsExpense = getOcsExpense(tenantId, nodeExpense);
                                ocsExpenseService.update(ocsExpense, new EntityWrapper<>());
                            }

                        }
                    }
                }
                InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                if (CollectionUtils.isNotEmpty(ocsExpenseList)) {
                    int batchCount = 1000;// 每批commit的个数
                    int batchLastIndex = batchCount;// 每批最后一个的下标
                    for (int index = 0; index < ocsExpenseList.size(); ) {
                        if (batchLastIndex >= ocsExpenseList.size()) {
                            batchLastIndex = ocsExpenseList.size();
                            ocsExpenseService.insertBatch(ocsExpenseList.subList(index, batchLastIndex));
                            logger.debug("报销单据添加成功");
                            break;// 数据插入完毕，退出循环
                        } else {
                            ocsExpenseService.insertBatch(ocsExpenseList.subList(index, batchLastIndex));
                            index = batchLastIndex;// 设置下一批下标
                            batchLastIndex = index + (batchCount - 1);
                        }
                    }
                }

                Thread.sleep(1000L);
                //申请单据
                List<OcsApply> ocsApplyList = new ArrayList<>();
                if (ocsApplyService.selectCount(new EntityWrapper<OcsApply>().eq(OcsApply.TENANT_ID, tenantId)) == 0) {
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<NodeBusinessTrip> nodeBusinessTripList = nodeBusinessTripService.selectCodeList();
                    if (CollectionUtils.isNotEmpty(nodeBusinessTripList)) {
                        ocsApplyList.clear();
                        for (NodeBusinessTrip nodeBusinessTrip : nodeBusinessTripList) {
                            OcsApply ocsApply = getOcsApply(tenantId, nodeBusinessTrip);
                            ocsApplyList.add(ocsApply);
                        }
                    }
                } else {
                    //目标中存在数据
                    InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                    String startDate = ocsApplyService.selectMaxDate();
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<NodeBusinessTrip> nodeBusinessTripList = nodeBusinessTripService.selectList(new EntityWrapper<NodeBusinessTrip>().between(NodeBusinessTrip.TS, startDate, DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN)));
                    if (CollectionUtils.isNotEmpty(nodeBusinessTripList)) {
                        InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                        ocsApplyList.clear();
                        for (NodeBusinessTrip nodeBusinessTrip : nodeBusinessTripList) {
                            if (ocsApplyService.selectList(new EntityWrapper<OcsApply>().eq(OcsApply.PK, nodeBusinessTrip.getPk())).size() == 0) {
                                OcsApply ocsApply = getOcsApply(tenantId, nodeBusinessTrip);
                                ocsApplyList.add(ocsApply);
                            } else {
                                OcsApply ocsApply = getOcsApply(tenantId, nodeBusinessTrip);
                                ocsApplyService.update(ocsApply, new EntityWrapper<>());
                            }
                        }
                    }
                }
                InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                if (CollectionUtils.isNotEmpty(ocsApplyList)) {
                    int batchCount = 1000;// 每批commit的个数
                    int batchLastIndex = batchCount;// 每批最后一个的下标
                    for (int index = 0; index < ocsApplyList.size(); ) {
                        if (batchLastIndex >= ocsApplyList.size()) {
                            batchLastIndex = ocsApplyList.size();
                            ocsApplyService.insertBatch(ocsApplyList.subList(index, batchLastIndex));
                            logger.debug("申请单据添加成功");
                            break;// 数据插入完毕，退出循环
                        } else {
                            ocsApplyService.insertBatch(ocsApplyList.subList(index, batchLastIndex));
                            index = batchLastIndex;// 设置下一批下标
                            batchLastIndex = index + (batchCount - 1);
                        }
                    }
                } else {
                    logger.debug("申请单无数据更新");
                }
                Thread.sleep(1000L);
                //借款单据
                List<OcsLoan> ocsLoanList = new ArrayList<>();
                if (ocsLoanService.selectCount(new EntityWrapper<OcsLoan>().eq(OcsLoan.TENANT_ID, tenantId)) == 0) {
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<NodeLoanbill> nodeLoanbillList = nodeLoanbillService.selectList(new EntityWrapper<>());
                    if (CollectionUtils.isNotEmpty(nodeLoanbillList)) {
                        ocsLoanList.clear();
                        for (NodeLoanbill nodeLoanbill : nodeLoanbillList) {
                            OcsLoan ocsLoan = getOcsLoan(tenantId, nodeLoanbill);
                            ocsLoanList.add(ocsLoan);
                        }
                    }
                } else {
                    //目标中存在数据
                    InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                    String startDate = ocsLoanService.selectMaxDate();
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<NodeLoanbill> nodeLoanbillList = nodeLoanbillService.selectList(new EntityWrapper<NodeLoanbill>().between(NodeLoanbill.TS, startDate, DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN)));
                    if (CollectionUtils.isNotEmpty(nodeLoanbillList)) {
                        InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                        ocsLoanList.clear();
                        for (NodeLoanbill nodeLoanbill : nodeLoanbillList) {
                            if (ocsLoanService.selectList(new EntityWrapper<OcsLoan>().eq(OcsLoan.PK, nodeLoanbill.getPk())).size() == 0) {
                                OcsLoan ocsLoan = getOcsLoan(tenantId, nodeLoanbill);
                                ocsLoanList.add(ocsLoan);
                            } else {
                                OcsLoan ocsLoan = getOcsLoan(tenantId, nodeLoanbill);
                                ocsLoanService.update(ocsLoan, new EntityWrapper<>());
                            }
                        }
                    }
                }
                InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                if (CollectionUtils.isNotEmpty(ocsLoanList)) {
                    int batchCount = 1000;// 每批commit的个数
                    int batchLastIndex = batchCount;// 每批最后一个的下标
                    for (int index = 0; index < ocsLoanList.size(); ) {
                        if (batchLastIndex >= ocsLoanList.size()) {
                            batchLastIndex = ocsLoanList.size();
                            ocsLoanService.insertBatch(ocsLoanList.subList(index, batchLastIndex));
                            logger.debug("借款单据添加成功");
                            break;// 数据插入完毕，退出循环
                        } else {
                            ocsLoanService.insertBatch(ocsLoanList.subList(index, batchLastIndex));
                            index = batchLastIndex;// 设置下一批下标
                            batchLastIndex = index + (batchCount - 1);
                        }
                    }
                } else {
                    logger.debug("借款单无更新数据");
                }
                Thread.sleep(1000L);
                //还款单据
                List<OcsPayment> ocsPaymentList = new ArrayList<>();
                if (ocsPaymentService.selectCount(new EntityWrapper<OcsPayment>().eq(OcsPayment.TENANT_ID, tenantId)) == 0) {
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<NodePayment> nodePaymentList = nodePaymentService.selectList(new EntityWrapper<>());
                    if (CollectionUtils.isNotEmpty(nodePaymentList)) {
                        ocsPaymentList.clear();
                        for (NodePayment nodePayment : nodePaymentList) {
                            OcsPayment ocsPayment = getOcsPayment(tenantId, nodePayment);
                            ocsPaymentList.add(ocsPayment);
                        }
                    }
                } else {
                    //目标中存在数据
                    InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                    String startDate = ocsPaymentService.selectMaxDate();
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<NodePayment> nodePaymentList = nodePaymentService.selectList(new EntityWrapper<NodePayment>().between(NodePayment.TS, startDate, DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN)));
                    if (CollectionUtils.isNotEmpty(nodePaymentList)) {
                        InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                        ocsPaymentList.clear();
                        for (NodePayment nodePayment : nodePaymentList) {
                            if (ocsPaymentService.selectList(new EntityWrapper<OcsPayment>().eq(OcsPayment.PK, nodePayment.getPk())).size() == 0) {
                                OcsPayment ocsPayment = getOcsPayment(tenantId, nodePayment);
                                ocsPaymentList.add(ocsPayment);
                            } else {
                                OcsPayment ocsPayment = getOcsPayment(tenantId, nodePayment);
                                ocsPaymentService.update(ocsPayment, new EntityWrapper<>());
                            }
                        }
                    }
                }
                InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                if (CollectionUtils.isNotEmpty(ocsPaymentList)) {
                    int batchCount = 1000;// 每批commit的个数
                    int batchLastIndex = batchCount;// 每批最后一个的下标
                    for (int index = 0; index < ocsPaymentList.size(); ) {
                        if (batchLastIndex >= ocsPaymentList.size()) {
                            batchLastIndex = ocsPaymentList.size();
                            ocsPaymentService.insertBatch(ocsPaymentList.subList(index, batchLastIndex));
                            logger.debug("还款单据添加成功");
                            break;// 数据插入完毕，退出循环
                        } else {
                            ocsPaymentService.insertBatch(ocsPaymentList.subList(index, batchLastIndex));
                            index = batchLastIndex;// 设置下一批下标
                            batchLastIndex = index + (batchCount - 1);
                        }
                    }
                } else {
                    logger.debug("还款单据无数据更新");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private OcsPayment getOcsPayment(String tenantId, NodePayment nodePayment) {
        OcsPayment ocsPayment = new OcsPayment();
        BeanUtils.copyProperties(nodePayment, ocsPayment);
        ocsPayment.setTenantId(tenantId);
        ocsPayment.setCreateTime(new Date());
        return ocsPayment;
    }

    private OcsLoan getOcsLoan(String tenantId, NodeLoanbill nodeLoanbill) {
        OcsLoan ocsLoan = new OcsLoan();
        BeanUtils.copyProperties(nodeLoanbill, ocsLoan);
        ocsLoan.setTenantId(tenantId);
        ocsLoan.setCreateTime(new Date());
        return ocsLoan;
    }

    private OcsApply getOcsApply(String tenantId, NodeBusinessTrip nodeBusinessTrip) {
        OcsApply ocsApply = new OcsApply();
        BeanUtils.copyProperties(nodeBusinessTrip, ocsApply);
        ocsApply.setTenantId(tenantId);
        ocsApply.setCreateTime(new Date());
        return ocsApply;
    }


    private OcsExpense getOcsExpense(String tenantId, NodeExpense nodeExpense) {
        OcsExpense ocsExpense = new OcsExpense();
        BeanUtils.copyProperties(nodeExpense, ocsExpense);
        ocsExpense.setTenantId(tenantId);
        ocsExpense.setCreateTime(new Date());
        return ocsExpense;
    }

}
