package com.ybz.dao;

import com.ybz.entity.OcsCommunicate;
import com.ybz.entity.OcsCommunicateExample;
import com.ybz.entity.OcsCommunicateWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OcsCommunicateMapper {
    int countByExample(OcsCommunicateExample example);

    int deleteByExample(OcsCommunicateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OcsCommunicateWithBLOBs record);

    int insertSelective(OcsCommunicateWithBLOBs record);

    List<OcsCommunicateWithBLOBs> selectByExampleWithBLOBs(OcsCommunicateExample example);

    List<OcsCommunicate> selectByExample(OcsCommunicateExample example);

    OcsCommunicateWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OcsCommunicateWithBLOBs record, @Param("example") OcsCommunicateExample example);

    int updateByExampleWithBLOBs(@Param("record") OcsCommunicateWithBLOBs record, @Param("example") OcsCommunicateExample example);

    int updateByExample(@Param("record") OcsCommunicate record, @Param("example") OcsCommunicateExample example);

    int updateByPrimaryKeySelective(OcsCommunicateWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OcsCommunicateWithBLOBs record);

    int updateByPrimaryKey(OcsCommunicate record);

    Double queryMoneyByDate(OcsCommunicateExample example);
}