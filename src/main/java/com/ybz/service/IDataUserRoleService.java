package com.ybz.service;

import java.util.List;

/**
 * 用户与角色对应关系
 *
 * @author zhangybt
 * @create 2017年09月22日 11:21
 **/
public interface IDataUserRoleService {

    void saveOrUpdate(Long userId, List<Long> roleIdList);

    /**
     * 根据用户ID，获取角色ID列表
     */
    List<Long> queryRoleIdList(Long userId);

    void delete(Long userId);
}
