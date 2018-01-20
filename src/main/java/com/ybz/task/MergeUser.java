package com.ybz.task;

import com.yonyou.iuap.context.InvocationInfoProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 定时任务(整合用户）
 *
 * @author zhangybt
 * @email zhangybt@yonyou.com
 * @date 2018年1月17日 下午1:34:24
 */


@Component("mergeUser")
public class MergeUser {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ISysTenantService sysTenantService;

    //-------------------用户(begin)--------------------
    //用户(旧)
    @Autowired
    private IUserTService userTService;
    //用户(新)
    @Autowired
    private IOcsUserService ocsUserService;
    //--------------------用户(end)---------------------

    /**
     * 整合用户数据
     */
    public void mergeUser() {
        logger.info("我是带参数的mergeUser方法，正在被执行");
        try {
            Thread.sleep(1000L);
            List<OcsUser> ocsUserList = new ArrayList<>();
            List<SysTenant> sysTenantList = sysTenantService.selectList(new EntityWrapper<>());
            for (SysTenant sysTenant : sysTenantList) {
                String tenantId = sysTenant.getTenantId();
                //目标中不存在数据
                if (ocsUserService.selectCount(new EntityWrapper<OcsUser>().eq(OcsUser.TENANT_ID, tenantId)) == 0) {
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<UserT> userTList = userTService.selectList(new EntityWrapper<UserT>().eq(UserT.DR, false));
                    if (CollectionUtils.isNotEmpty(userTList)) {
                        for (UserT userT : userTList) {
                            OcsUser ocsUser = getOcsUser(tenantId, userT);
                            ocsUserList.add(ocsUser);
                        }
                    }
                } else {
                    //查询时间戳
                    InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                    String startDate = ocsUserService.selectMaxDate();
                    InvocationInfoProxy.setTenantid(tenantId);
                    List<UserT> userTList = userTService.selectList(new EntityWrapper<UserT>().eq(UserT.DR, false).between(UserT.REGISTERDATE, startDate, DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN)));
                    if (CollectionUtils.isNotEmpty(userTList)) {
                        InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                        for (UserT userT : userTList) {
                            //目标中不存在
                            if (ocsUserService.selectList(new EntityWrapper<OcsUser>().eq(OcsUser.USERID, userT.getUserid())).size() == 0) {
                                OcsUser ocsUser = getOcsUser(tenantId, userT);
                                ocsUserList.add(ocsUser);
                            } else {
                                //目标存在
                                OcsUser ocsUser = getOcsUser(tenantId, userT);
                                ocsUserService.update(ocsUser, new EntityWrapper<>());
                            }
                        }
                    }
                }
                InvocationInfoProxy.setTenantid(TenantUtils.DEFAULT_TENANT);
                if (CollectionUtils.isNotEmpty(ocsUserList)) {
                    int batchCount = 1000;// 每批commit的个数
                    int batchLastIndex = batchCount;// 每批最后一个的下标
                    for (int index = 0; index < ocsUserList.size(); ) {
                        if (batchLastIndex >= ocsUserList.size()) {
                            batchLastIndex = ocsUserList.size();
                            ocsUserService.insertBatch(ocsUserList.subList(index, batchLastIndex));
                            logger.debug("用户融合成功");
                            break;// 数据插入完毕，退出循环
                        } else {
                            ocsUserService.insertBatch(ocsUserList.subList(index, batchLastIndex));
                            index = batchLastIndex;// 设置下一批下标
                            batchLastIndex = index + (batchCount - 1);
                        }
                    }
                } else {
                    logger.info("用户数据无更新");
                }
            }
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }

    }

    private OcsUser getOcsUser(String tenantId, UserT userT) {
        OcsUser ocsUser = new OcsUser();
        BeanUtils.copyProperties(userT, ocsUser);
        ocsUser.setTenantId(tenantId);
        ocsUser.setCreateTime(new Date());
        return ocsUser;
    }
}
