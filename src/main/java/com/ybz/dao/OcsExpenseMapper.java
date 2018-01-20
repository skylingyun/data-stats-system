package com.ybz.dao;

import com.ybz.entity.OcsExpense;
import com.ybz.entity.OcsExpenseExample;
import com.ybz.entity.OcsExpenseWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OcsExpenseMapper {
    int countByExample(OcsExpenseExample example);

    int deleteByExample(OcsExpenseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OcsExpenseWithBLOBs record);

    int insertSelective(OcsExpenseWithBLOBs record);

    List<OcsExpenseWithBLOBs> selectByExampleWithBLOBs(OcsExpenseExample example);

    List<OcsExpense> selectByExample(OcsExpenseExample example);

    OcsExpenseWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OcsExpenseWithBLOBs record, @Param("example") OcsExpenseExample example);

    int updateByExampleWithBLOBs(@Param("record") OcsExpenseWithBLOBs record, @Param("example") OcsExpenseExample example);

    int updateByExample(@Param("record") OcsExpense record, @Param("example") OcsExpenseExample example);

    int updateByPrimaryKeySelective(OcsExpenseWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OcsExpenseWithBLOBs record);

    int updateByPrimaryKey(OcsExpense record);

    int distinctUserIdCount(OcsExpenseExample example);

    Double queryMoneyByDate(OcsExpenseExample example);
}