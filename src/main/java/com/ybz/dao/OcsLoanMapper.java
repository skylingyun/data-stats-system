package com.ybz.dao;

import com.ybz.entity.OcsLoan;
import com.ybz.entity.OcsLoanExample;
import com.ybz.entity.OcsLoanWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OcsLoanMapper {
    int countByExample(OcsLoanExample example);

    int deleteByExample(OcsLoanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OcsLoanWithBLOBs record);

    int insertSelective(OcsLoanWithBLOBs record);

    List<OcsLoanWithBLOBs> selectByExampleWithBLOBs(OcsLoanExample example);

    List<OcsLoan> selectByExample(OcsLoanExample example);

    OcsLoanWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OcsLoanWithBLOBs record, @Param("example") OcsLoanExample example);

    int updateByExampleWithBLOBs(@Param("record") OcsLoanWithBLOBs record, @Param("example") OcsLoanExample example);

    int updateByExample(@Param("record") OcsLoan record, @Param("example") OcsLoanExample example);

    int updateByPrimaryKeySelective(OcsLoanWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OcsLoanWithBLOBs record);

    int updateByPrimaryKey(OcsLoan record);

    Double queryMoneyByDate(OcsLoanExample example);
}