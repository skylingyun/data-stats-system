package com.ybz.service.impl;

import com.ybz.dao.ManagerUserMapper;
import com.ybz.entity.ManagerUser;
import com.ybz.service.IDataManagerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 管理员实现类
 *
 * @author zhangybt
 * @create 2017年09月16日 16:39
 **/
@Service
public class DataManagerUserServiceImpl implements IDataManagerUserService {

    @Autowired
    private ManagerUserMapper managerUserMapperDao;
    @Override
    public List<String> queryAllPerms(Long userId) {
        return managerUserMapperDao.queryAllPerms(userId);
    }

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return null;
    }

    @Override
    public ManagerUser queryByUserName(String username) {
        return managerUserMapperDao.queryByUserName(username);
    }

    @Override
    public ManagerUser queryObject(Long userId) {
        return null;
    }

    @Override
    public List<ManagerUser> queryList(Map<String, Object> map) {
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return 0;
    }

    @Override
    public void save(ManagerUser user) {

    }

    @Override
    public void update(ManagerUser user) {

    }

    @Override
    public void deleteBatch(Long[] userIds) {

    }

    @Override
    public int updatePassword(Long userId, String password, String newPassword) {
        return 0;
    }
}
