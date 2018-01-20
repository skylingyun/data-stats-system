package com.ybz.dao;

import com.ybz.entity.OcsTravel;
import com.ybz.entity.OcsTravelExample;
import com.ybz.entity.OcsTravelWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OcsTravelMapper {
    int countByExample(OcsTravelExample example);

    int deleteByExample(OcsTravelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OcsTravelWithBLOBs record);

    int insertSelective(OcsTravelWithBLOBs record);

    List<OcsTravelWithBLOBs> selectByExampleWithBLOBs(OcsTravelExample example);

    List<OcsTravel> selectByExample(OcsTravelExample example);

    OcsTravelWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OcsTravelWithBLOBs record, @Param("example") OcsTravelExample example);

    int updateByExampleWithBLOBs(@Param("record") OcsTravelWithBLOBs record, @Param("example") OcsTravelExample example);

    int updateByExample(@Param("record") OcsTravel record, @Param("example") OcsTravelExample example);

    int updateByPrimaryKeySelective(OcsTravelWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OcsTravelWithBLOBs record);

    int updateByPrimaryKey(OcsTravel record);

    Double queryMoneyByDate(OcsTravelExample example);
}