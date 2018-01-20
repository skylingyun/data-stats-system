package com.ybz.dao;

import com.ybz.entity.OcsApply;
import com.ybz.entity.OcsApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OcsApplyMapper {
    int countByExample(OcsApplyExample example);

    int deleteByExample(OcsApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OcsApply record);

    int insertSelective(OcsApply record);

    List<OcsApply> selectByExampleWithBLOBs(OcsApplyExample example);

    List<OcsApply> selectByExample(OcsApplyExample example);

    OcsApply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OcsApply record, @Param("example") OcsApplyExample example);

    int updateByExampleWithBLOBs(@Param("record") OcsApply record, @Param("example") OcsApplyExample example);

    int updateByExample(@Param("record") OcsApply record, @Param("example") OcsApplyExample example);

    int updateByPrimaryKeySelective(OcsApply record);

    int updateByPrimaryKeyWithBLOBs(OcsApply record);

    int updateByPrimaryKey(OcsApply record);

    Double queryMoneyByDate(OcsApplyExample example);
}