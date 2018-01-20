package com.ybz.dao;

import com.ybz.entity.NcInfo;
import com.ybz.entity.NcInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NcInfoMapper {
    int countByExample(NcInfoExample example);

    int deleteByExample(NcInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NcInfo record);

    int insertSelective(NcInfo record);

    List<NcInfo> selectByExample(NcInfoExample example);

    NcInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NcInfo record, @Param("example") NcInfoExample example);

    int updateByExample(@Param("record") NcInfo record, @Param("example") NcInfoExample example);

    int updateByPrimaryKeySelective(NcInfo record);

    int updateByPrimaryKey(NcInfo record);

    NcInfo selectOsType();
}