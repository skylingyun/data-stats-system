package com.ybz.dao;

import com.ybz.entity.OcsEating;
import com.ybz.entity.OcsEatingExample;
import com.ybz.entity.OcsEatingWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OcsEatingMapper {
    int countByExample(OcsEatingExample example);

    int deleteByExample(OcsEatingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OcsEatingWithBLOBs record);

    int insertSelective(OcsEatingWithBLOBs record);

    List<OcsEatingWithBLOBs> selectByExampleWithBLOBs(OcsEatingExample example);

    List<OcsEating> selectByExample(OcsEatingExample example);

    OcsEatingWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OcsEatingWithBLOBs record, @Param("example") OcsEatingExample example);

    int updateByExampleWithBLOBs(@Param("record") OcsEatingWithBLOBs record, @Param("example") OcsEatingExample example);

    int updateByExample(@Param("record") OcsEating record, @Param("example") OcsEatingExample example);

    int updateByPrimaryKeySelective(OcsEatingWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OcsEatingWithBLOBs record);

    int updateByPrimaryKey(OcsEating record);

    Double queryMoneyByDate(OcsEatingExample example);
}