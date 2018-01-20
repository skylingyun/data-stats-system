package com.ybz.dao;

import com.ybz.entity.TenantUserRelation;
import com.ybz.entity.TenantUserRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TenantUserRelationMapper {
    int countByExample(TenantUserRelationExample example);

    int deleteByExample(TenantUserRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TenantUserRelation record);

    int insertSelective(TenantUserRelation record);

    List<TenantUserRelation> selectByExample(TenantUserRelationExample example);

    TenantUserRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TenantUserRelation record, @Param("example") TenantUserRelationExample example);

    int updateByExample(@Param("record") TenantUserRelation record, @Param("example") TenantUserRelationExample example);

    int updateByPrimaryKeySelective(TenantUserRelation record);

    int updateByPrimaryKey(TenantUserRelation record);

    int insertBatch(List<TenantUserRelation> list);
}