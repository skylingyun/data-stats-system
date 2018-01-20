package com.ybz.dao;

import com.ybz.entity.OcsUser;
import com.ybz.entity.OcsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OcsUserMapper {
    int countByExample(OcsUserExample example);

    int deleteByExample(OcsUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OcsUser record);

    int insertSelective(OcsUser record);

    List<OcsUser> selectByExampleWithBLOBs(OcsUserExample example);

    List<OcsUser> selectByExample(OcsUserExample example);

    OcsUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OcsUser record, @Param("example") OcsUserExample example);

    int updateByExampleWithBLOBs(@Param("record") OcsUser record, @Param("example") OcsUserExample example);

    int updateByExample(@Param("record") OcsUser record, @Param("example") OcsUserExample example);

    int updateByPrimaryKeySelective(OcsUser record);

    int updateByPrimaryKeyWithBLOBs(OcsUser record);

    int updateByPrimaryKey(OcsUser record);
}