package com.ybz.dao;

import com.ybz.entity.OcsOther;
import com.ybz.entity.OcsOtherExample;
import com.ybz.entity.OcsOtherWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OcsOtherMapper {
    int countByExample(OcsOtherExample example);

    int deleteByExample(OcsOtherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OcsOtherWithBLOBs record);

    int insertSelective(OcsOtherWithBLOBs record);

    List<OcsOtherWithBLOBs> selectByExampleWithBLOBs(OcsOtherExample example);

    List<OcsOther> selectByExample(OcsOtherExample example);

    OcsOtherWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OcsOtherWithBLOBs record, @Param("example") OcsOtherExample example);

    int updateByExampleWithBLOBs(@Param("record") OcsOtherWithBLOBs record, @Param("example") OcsOtherExample example);

    int updateByExample(@Param("record") OcsOther record, @Param("example") OcsOtherExample example);

    int updateByPrimaryKeySelective(OcsOtherWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OcsOtherWithBLOBs record);

    int updateByPrimaryKey(OcsOther record);

    Double queryMoneyByDate(OcsOtherExample example);
}