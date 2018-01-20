package com.ybz.dao;

import com.ybz.entity.OcsPayment;
import com.ybz.entity.OcsPaymentExample;
import com.ybz.entity.OcsPaymentWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OcsPaymentMapper {
    int countByExample(OcsPaymentExample example);

    int deleteByExample(OcsPaymentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OcsPaymentWithBLOBs record);

    int insertSelective(OcsPaymentWithBLOBs record);

    List<OcsPaymentWithBLOBs> selectByExampleWithBLOBs(OcsPaymentExample example);

    List<OcsPayment> selectByExample(OcsPaymentExample example);

    OcsPaymentWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OcsPaymentWithBLOBs record, @Param("example") OcsPaymentExample example);

    int updateByExampleWithBLOBs(@Param("record") OcsPaymentWithBLOBs record, @Param("example") OcsPaymentExample example);

    int updateByExample(@Param("record") OcsPayment record, @Param("example") OcsPaymentExample example);

    int updateByPrimaryKeySelective(OcsPaymentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OcsPaymentWithBLOBs record);

    int updateByPrimaryKey(OcsPayment record);

    Double queryMoneyByDate(OcsPaymentExample example);
}