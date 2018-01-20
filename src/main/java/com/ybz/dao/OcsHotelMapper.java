package com.ybz.dao;

import com.ybz.entity.OcsHotel;
import com.ybz.entity.OcsHotelExample;
import com.ybz.entity.OcsHotelWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OcsHotelMapper {
    int countByExample(OcsHotelExample example);

    int deleteByExample(OcsHotelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OcsHotelWithBLOBs record);

    int insertSelective(OcsHotelWithBLOBs record);

    List<OcsHotelWithBLOBs> selectByExampleWithBLOBs(OcsHotelExample example);

    List<OcsHotel> selectByExample(OcsHotelExample example);

    OcsHotelWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OcsHotelWithBLOBs record, @Param("example") OcsHotelExample example);

    int updateByExampleWithBLOBs(@Param("record") OcsHotelWithBLOBs record, @Param("example") OcsHotelExample example);

    int updateByExample(@Param("record") OcsHotel record, @Param("example") OcsHotelExample example);

    int updateByPrimaryKeySelective(OcsHotelWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OcsHotelWithBLOBs record);

    int updateByPrimaryKey(OcsHotel record);

    Double queryMoneyByDate(OcsHotelExample example);
}