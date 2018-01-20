package com.ybz.dao;

import com.ybz.entity.ManagerUser;
import com.ybz.entity.ManagerUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ManagerUserMapper {
    int countByExample(ManagerUserExample example);

    int deleteByExample(ManagerUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(ManagerUser record);

    int insertSelective(ManagerUser record);

    List<ManagerUser> selectByExample(ManagerUserExample example);

    ManagerUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") ManagerUser record, @Param("example") ManagerUserExample example);

    int updateByExample(@Param("record") ManagerUser record, @Param("example") ManagerUserExample example);

    int updateByPrimaryKeySelective(ManagerUser record);

    int updateByPrimaryKey(ManagerUser record);

    /**
     * 查询用户的所有权限
     * @param userId  用户ID
     */
    List<String> queryAllPerms(Long userId);

    /**
     * 根据用户名，查询系统用户
     */
    ManagerUser queryByUserName(String username);
}