package com.ybz.controller;

import com.ybz.entity.ManagerUser;
import com.ybz.utils.ShiroUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * controller的公共组件
 *
 * @author zhangybt
 * @create 2017年09月22日 11:15
 **/
public abstract class AbstractController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected ManagerUser getUser() {
        return ShiroUtils.getUserEntity();
    }

    protected Long getUserId() {
        return getUser().getUserId();
    }
}
