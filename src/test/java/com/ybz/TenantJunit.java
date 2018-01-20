package com.ybz;

import com.ybz.dao.UserMapper;
import com.ybz.entity.User;
import com.ybz.entity.UserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 租户测试类
 *
 * @author zhangybt
 * @create 2017年08月02日 13:49
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring-*.xml"})
public class TenantJunit {

    @Autowired
    private UserMapper userMapperDao;

    @Test
    public void getUserByUserMobile() {
        String userMobile = "13810613549";
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneEqualTo(userMobile);
        criteria.andDrEqualTo(false);
        userExample.setDistinct(true);
        userExample.setOrderByClause("ts desc");
        List<User> userList = userMapperDao.selectByExample(userExample);
        System.out.println(userList);
    }

}
