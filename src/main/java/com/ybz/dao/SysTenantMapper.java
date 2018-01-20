package com.ybz.dao;

import com.ybz.entity.SysTenant;
import com.ybz.entity.SysTenantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysTenantMapper {
    int countByExample(SysTenantExample example);

    int deleteByExample(SysTenantExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysTenant record);

    int insertSelective(SysTenant record);

    List<SysTenant> selectByExample(SysTenantExample example);

    SysTenant selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysTenant record, @Param("example") SysTenantExample example);

    int updateByExample(@Param("record") SysTenant record, @Param("example") SysTenantExample example);

    int updateByPrimaryKeySelective(SysTenant record);

    int updateByPrimaryKey(SysTenant record);
}