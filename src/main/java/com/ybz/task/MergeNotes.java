package com.ybz.task;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.yonyou.common.utils.DateUtils;
import com.yonyou.common.utils.TenantUtils;
import com.yonyou.iuap.context.InvocationInfoProxy;
import com.yonyou.modules.base.entity.*;
import com.yonyou.modules.base.service.*;
import com.yonyou.modules.basic.entity.*;
import com.yonyou.modules.basic.service.*;
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
 * 定时任务(整合记事）
 *
 * @author zhangybt
 * @email zhangybt@yonyou.com
 * @date 2018年1月17日 下午1:34:24
 */
@Component("mergeNotes")
public class MergeNotes {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ISysTenantService sysTenantService;

    //-------------------记事(begin)--------------------
    //餐饮(旧)
    @Autowired
    private INodeEatingService nodeEatingService;
    //餐饮(新)
    @Autowired
    private IOcsEatingService ocsEatingService;
    //出行(旧)
    @Autowired
    private INodeTravelService nodeTravelService;
    //出行(新)
    @Autowired
    private IOcsTravelService ocsTravelService;
    //通讯(旧)
    @Autowired
    private INodeCommunicateService nodeCommunicateService;
    //通讯(新)
    @Autowired
    private IOcsCommunicateService ocsCommunicateService;
    //住宿(旧)
    @Autowired
    private INodeHotelService nodeHotelService;
    //住宿(新)
    @Autowired
    private IOcsHotelService ocsHotelService;
    //其它(旧)
    @Autowired
    private INodeOtherService nodeOtherService;
    //其它(新)
    @Autowired
    private IOcsOtherService ocsOtherService;
    //-------------------记事(end)----------------------

    /**
     * 整合餐饮记事
     */
    public void mergeNotes() {
        logger.info("我是带参数的mergeNotes方法，正在被执行");
        try {
            Thread.sleep(1000L);
            List<SysTenant> sysTenantList = sysTenantService.selectList(new EntityWrapper<>());
            for (SysTenant sysTenant : sysTenantList) {
                String tenantId = sysTenant.getTenantId();
                //餐饮记事
                //目标中不存在数据
                List<OcsEating> ocsEatingList = new ArrayList<>();
                if (ocsEatingService.selectCount(new EntityWrapper<OcsEating>().eq(OcsEating.TENANT_ID, tenantId)) == 0) {
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<NodeEating> nodeEatingList = nodeEatingService.selectList(new EntityWrapper<>());
                    if (CollectionUtils.isNotEmpty(nodeEatingList)) {
                        ocsEatingList.clear();
                        for (NodeEating nodeEating : nodeEatingList) {
                            OcsEating ocsEating = getOcsEating(tenantId, nodeEating);
                            ocsEatingList.add(ocsEating);
                        }
                    }
                } else {
                    String startDate = ocsEatingService.selectMaxDate();
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<NodeEating> nodeEatingList = nodeEatingService.selectList(new EntityWrapper<NodeEating>().between(NodeEating.TS, startDate, DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN)));
                    if (CollectionUtils.isNotEmpty(nodeEatingList)) {
                        InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                        ocsEatingList.clear();
                        for (NodeEating nodeEating : nodeEatingList) {
                            if (ocsEatingService.selectList(new EntityWrapper<OcsEating>().eq(OcsEating.PK, nodeEating.getPk())).size() == 0) {
                                OcsEating ocsEating = getOcsEating(tenantId, nodeEating);
                                ocsEatingList.add(ocsEating);
                            } else {
                                OcsEating ocsEating = getOcsEating(tenantId, nodeEating);
                                ocsEatingService.update(ocsEating, new EntityWrapper<>());
                            }

                        }
                    }
                }
                InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                if (CollectionUtils.isNotEmpty(ocsEatingList)) {
                    int batchCount = 1000;// 每批commit的个数
                    int batchLastIndex = batchCount;// 每批最后一个的下标
                    for (int index = 0; index < ocsEatingList.size(); ) {
                        if (batchLastIndex >= ocsEatingList.size()) {
                            batchLastIndex = ocsEatingList.size();
                            ocsEatingService.insertBatch(ocsEatingList.subList(index, batchLastIndex));
                            logger.debug("餐饮记事添加成功");
                            break;// 数据插入完毕，退出循环
                        } else {
                            ocsEatingService.insertBatch(ocsEatingList.subList(index, batchLastIndex));
                            index = batchLastIndex;// 设置下一批下标
                            batchLastIndex = index + (batchCount - 1);
                        }
                    }
                }
                Thread.sleep(1000L);
                //出行记事
                //目标中不存在数据
                List<OcsTravel> ocsTravelList = new ArrayList<>();
                if (ocsTravelService.selectCount(new EntityWrapper<OcsTravel>().eq(OcsTravel.TENANT_ID, tenantId)) == 0) {
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<NodeTravel> nodeTravelList = nodeTravelService.selectList(new EntityWrapper<>());
                    if (CollectionUtils.isNotEmpty(nodeTravelList)) {
                        ocsTravelList.clear();
                        for (NodeTravel nodeTravel : nodeTravelList) {
                            OcsTravel ocsTravel = getOcsTravel(tenantId, nodeTravel);
                            ocsTravelList.add(ocsTravel);
                        }
                    }
                } else {
                    InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                    String startDate = ocsTravelService.selectMaxDate();
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<NodeTravel> nodeTravelList = nodeTravelService.selectList(new EntityWrapper<NodeTravel>().between(NodeEating.TS, startDate, DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN)));
                    if (CollectionUtils.isNotEmpty(nodeTravelList)) {
                        InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                        ocsTravelList.clear();
                        for (NodeTravel nodeTravel : nodeTravelList) {
                            if (ocsTravelService.selectList(new EntityWrapper<OcsTravel>().eq(OcsTravel.PK, nodeTravel.getPk())).size() == 0) {
                                OcsTravel ocsTravel = getOcsTravel(tenantId, nodeTravel);
                                ocsTravelList.add(ocsTravel);
                            } else {
                                OcsTravel ocsTravel = getOcsTravel(tenantId, nodeTravel);
                                ocsTravelService.update(ocsTravel, new EntityWrapper<>());
                            }
                        }
                    }
                }
                InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                if (CollectionUtils.isNotEmpty(ocsTravelList)) {
                    int batchCount = 1000;// 每批commit的个数
                    int batchLastIndex = batchCount;// 每批最后一个的下标
                    for (int index = 0; index < ocsTravelList.size(); ) {
                        if (batchLastIndex >= ocsTravelList.size()) {
                            batchLastIndex = ocsTravelList.size();
                            ocsTravelService.insertBatch(ocsTravelList.subList(index, batchLastIndex));
                            logger.debug("出行记事添加成功");
                            break;// 数据插入完毕，退出循环
                        } else {
                            ocsTravelService.insertBatch(ocsTravelList.subList(index, batchLastIndex));
                            index = batchLastIndex;// 设置下一批下标
                            batchLastIndex = index + (batchCount - 1);
                        }
                    }
                } else {
                    logger.debug("出行记事无数据更新");
                }
                Thread.sleep(1000L);
                //通讯记事
                //目标中不存在数据
                List<OcsCommunicate> ocsCommunicateList = new ArrayList<>();
                if (ocsCommunicateService.selectCount(new EntityWrapper<OcsCommunicate>().eq(OcsCommunicate.TENANT_ID, tenantId)) == 0) {
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<NodeCommunicate> nodeCommunicateList = nodeCommunicateService.selectList(new EntityWrapper<>());
                    if (CollectionUtils.isNotEmpty(nodeCommunicateList)) {
                        ocsCommunicateList.clear();
                        for (NodeCommunicate nodeCommunicate : nodeCommunicateList) {
                            OcsCommunicate ocsCommunicate = getOcsCommunicate(tenantId, nodeCommunicate);
                            ocsCommunicateList.add(ocsCommunicate);
                        }
                    }
                } else {
                    //目标中存在数据
                    InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                    String startDate = ocsCommunicateService.selectMaxDate();
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<NodeCommunicate> nodeCommunicateList = nodeCommunicateService.selectList(new EntityWrapper<NodeCommunicate>().between(NodeCommunicate.TS, startDate, DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN)));
                    if (CollectionUtils.isNotEmpty(nodeCommunicateList)) {
                        InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                        ocsCommunicateList.clear();
                        for (NodeCommunicate nodeCommunicate : nodeCommunicateList) {
                            if (ocsCommunicateService.selectList(new EntityWrapper<OcsCommunicate>().eq(OcsCommunicate.PK, nodeCommunicate.getPk())).size() == 0) {
                                OcsCommunicate ocsCommunicate = getOcsCommunicate(tenantId, nodeCommunicate);
                                ocsCommunicateList.add(ocsCommunicate);
                            } else {
                                OcsCommunicate ocsCommunicate = getOcsCommunicate(tenantId, nodeCommunicate);
                                ocsCommunicateService.update(ocsCommunicate, new EntityWrapper<>());
                            }

                        }
                    }
                }
                InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                if (CollectionUtils.isNotEmpty(ocsCommunicateList)) {
                    int batchCount = 1000;// 每批commit的个数
                    int batchLastIndex = batchCount;// 每批最后一个的下标
                    for (int index = 0; index < ocsCommunicateList.size(); ) {
                        if (batchLastIndex >= ocsCommunicateList.size()) {
                            batchLastIndex = ocsCommunicateList.size();
                            ocsCommunicateService.insertBatch(ocsCommunicateList.subList(index, batchLastIndex));
                            logger.debug("通讯记事添加成功");
                            break;// 数据插入完毕，退出循环
                        } else {
                            ocsCommunicateService.insertBatch(ocsCommunicateList.subList(index, batchLastIndex));
                            index = batchLastIndex;// 设置下一批下标
                            batchLastIndex = index + (batchCount - 1);
                        }
                    }
                } else {
                    logger.debug("通讯记事无更新数据");
                }
                Thread.sleep(1000L);
                //住宿记事
                List<OcsHotel> ocsHotelList = new ArrayList<>();
                if (ocsHotelService.selectCount(new EntityWrapper<OcsHotel>().eq(OcsHotel.TENANT_ID, tenantId)) == 0) {
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<NodeHotel> nodeHotelList = nodeHotelService.selectList(new EntityWrapper<>());
                    if (CollectionUtils.isNotEmpty(nodeHotelList)) {
                        ocsHotelList.clear();
                        for (NodeHotel nodeHotel : nodeHotelList) {
                            OcsHotel ocsHotel = getOcsHotel(tenantId, nodeHotel);
                            ocsHotelList.add(ocsHotel);
                        }
                    }
                } else {
                    //目标中存在数据
                    InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                    String startDate = ocsHotelService.selectMaxDate();
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<NodeHotel> nodeHotelList = nodeHotelService.selectList(new EntityWrapper<NodeHotel>().between(NodeHotel.TS, startDate, DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN)));
                    if (CollectionUtils.isNotEmpty(nodeHotelList)) {
                        InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                        ocsHotelList.clear();
                        for (NodeHotel nodeHotel : nodeHotelList) {
                            if (ocsHotelService.selectList(new EntityWrapper<OcsHotel>().eq(OcsHotel.PK, nodeHotel.getPk())).size() == 0) {
                                OcsHotel ocsHotel = getOcsHotel(tenantId, nodeHotel);
                                ocsHotelList.add(ocsHotel);
                            } else {
                                OcsHotel ocsHotel = getOcsHotel(tenantId, nodeHotel);
                                ocsHotelService.update(ocsHotel, new EntityWrapper<>());
                            }

                        }
                    }
                }
                InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                if (CollectionUtils.isNotEmpty(ocsHotelList)) {
                    int batchCount = 1000;// 每批commit的个数
                    int batchLastIndex = batchCount;// 每批最后一个的下标
                    for (int index = 0; index < ocsHotelList.size(); ) {
                        if (batchLastIndex >= ocsHotelList.size()) {
                            batchLastIndex = ocsHotelList.size();
                            ocsHotelService.insertBatch(ocsHotelList.subList(index, batchLastIndex));
                            logger.debug("住宿记事添加成功");
                            break;// 数据插入完毕，退出循环
                        } else {
                            ocsHotelService.insertBatch(ocsHotelList.subList(index, batchLastIndex));
                            index = batchLastIndex;// 设置下一批下标
                            batchLastIndex = index + (batchCount - 1);
                        }
                    }
                } else {
                    logger.debug("住宿记事无更新数据");
                }
                Thread.sleep(1000L);
                //其它记事
                List<OcsOther> ocsOtherList = new ArrayList<>();
                if (ocsOtherService.selectCount(new EntityWrapper<OcsOther>().eq(OcsOther.TENANT_ID, tenantId)) == 0) {
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<NodeOther> nodeOtherList = nodeOtherService.selectList(new EntityWrapper<>());
                    if (CollectionUtils.isNotEmpty(nodeOtherList)) {
                        ocsOtherList.clear();
                        for (NodeOther nodeOther : nodeOtherList) {
                            OcsOther ocsOther = getOcsOther(tenantId, nodeOther);
                            ocsOtherList.add(ocsOther);
                        }
                    }
                } else {
                    //目标中存在数据
                    InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                    String startDate = ocsOtherService.selectMaxDate();
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<NodeOther> nodeOtherList = nodeOtherService.selectList(new EntityWrapper<NodeOther>().between(NodeOther.TS, startDate, DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN)));
                    if (CollectionUtils.isNotEmpty(nodeOtherList)) {
                        InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                        ocsOtherList.clear();
                        for (NodeOther nodeOther : nodeOtherList) {
                            if (ocsOtherService.selectList(new EntityWrapper<OcsOther>().eq(OcsOther.PK, nodeOther.getPk())).size() == 0) {
                                OcsOther ocsOther = getOcsOther(tenantId, nodeOther);
                                ocsOtherList.add(ocsOther);
                            } else {
                                OcsOther ocsOther = getOcsOther(tenantId, nodeOther);
                                ocsOtherService.update(ocsOther, new EntityWrapper<>());
                            }
                        }
                    }
                }
                InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                if (CollectionUtils.isNotEmpty(ocsOtherList)) {
                    int batchCount = 1000;// 每批commit的个数
                    int batchLastIndex = batchCount;// 每批最后一个的下标
                    for (int index = 0; index < ocsOtherList.size(); ) {
                        if (batchLastIndex >= ocsOtherList.size()) {
                            batchLastIndex = ocsOtherList.size();
                            ocsOtherService.insertBatch(ocsOtherList.subList(index, batchLastIndex));
                            logger.debug("其它记事添加成功");
                            break;// 数据插入完毕，退出循环
                        } else {
                            ocsOtherService.insertBatch(ocsOtherList.subList(index, batchLastIndex));
                            index = batchLastIndex;// 设置下一批下标
                            batchLastIndex = index + (batchCount - 1);
                        }
                    }
                } else {
                    logger.debug("其它记事无更新数据");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private OcsOther getOcsOther(String tenantId, NodeOther nodeOther) {
        OcsOther ocsOther = new OcsOther();
        BeanUtils.copyProperties(nodeOther, ocsOther);
        ocsOther.setTenantId(tenantId);
        ocsOther.setCreateTime(new Date());
        return ocsOther;
    }

    private OcsHotel getOcsHotel(String tenantId, NodeHotel nodeHotel) {
        OcsHotel ocsHotel = new OcsHotel();
        BeanUtils.copyProperties(nodeHotel, ocsHotel);
        ocsHotel.setTenantId(tenantId);
        ocsHotel.setCreateTime(new Date());
        return ocsHotel;
    }

    private OcsCommunicate getOcsCommunicate(String tenantId, NodeCommunicate nodeCommunicate) {
        OcsCommunicate ocsCommunicate = new OcsCommunicate();
        BeanUtils.copyProperties(nodeCommunicate, ocsCommunicate);
        ocsCommunicate.setTenantId(tenantId);
        ocsCommunicate.setCreateTime(new Date());
        return ocsCommunicate;
    }

    private OcsTravel getOcsTravel(String tenantId, NodeTravel nodeTravel) {
        OcsTravel ocsTravel = new OcsTravel();
        BeanUtils.copyProperties(nodeTravel, ocsTravel);
        ocsTravel.setTenantId(tenantId);
        ocsTravel.setCreateTime(new Date());
        return ocsTravel;
    }

    private OcsEating getOcsEating(String tenantId, NodeEating nodeEating) {
        OcsEating ocsEating = new OcsEating();
        BeanUtils.copyProperties(nodeEating, ocsEating);
        ocsEating.setTenantId(tenantId);
        ocsEating.setCreateTime(new Date());
        return ocsEating;
    }
}
