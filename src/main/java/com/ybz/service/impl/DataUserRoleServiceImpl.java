package com.ybz.service.impl;

import com.ybz.service.IDataUserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户与角色对应关系
 *
 * @author zhangybt
 * @create 2017年09月22日 11:23
 **/
@Service
public class DataUserRoleServiceImpl implements IDataUserRoleService {
    @Override
    public void saveOrUpdate(Long userId, List<Long> roleIdList) {

    }

    @Override
    public List<Long> queryRoleIdList(Long userId) {
        return null;
    }

    @Override
    public void delete(Long userId) {

    }
}
