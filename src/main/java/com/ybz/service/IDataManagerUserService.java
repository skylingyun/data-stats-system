package com.ybz.service;

import com.ybz.entity.ManagerUser;

import java.util.List;
import java.util.Map;

/**
 * 管理员
 *
 * @author zhangybt
 * @create 2017年09月16日 16:39
 **/
public interface IDataManagerUserService {

    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 查询用户的所有菜单ID
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 根据用户名，查询系统用户
     */
    ManagerUser queryByUserName(String username);

    /**
     * 根据用户ID，查询用户
     * @param userId
     * @return
     */
    ManagerUser queryObject(Long userId);

    /**
     * 查询用户列表
     */
    List<ManagerUser> queryList(Map<String, Object> map);

    /**
     * 查询总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存用户
     */
    void save(ManagerUser user);

    /**
     * 修改用户
     */
    void update(ManagerUser user);

    /**
     * 删除用户
     */
    void deleteBatch(Long[] userIds);

    /**
     * 修改密码
     * @param userId       用户ID
     * @param password     原密码
     * @param newPassword  新密码
     */
    int updatePassword(Long userId, String password, String newPassword);

}
