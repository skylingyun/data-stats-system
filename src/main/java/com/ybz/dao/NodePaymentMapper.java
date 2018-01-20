package com.ybz.dao;

import com.ybz.entity.NodePayment;
import com.ybz.entity.NodePaymentExample;
import com.ybz.entity.NodePaymentWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NodePaymentMapper {
    int countByExample(NodePaymentExample example);

    int deleteByExample(NodePaymentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NodePaymentWithBLOBs record);

    int insertSelective(NodePaymentWithBLOBs record);

    List<NodePaymentWithBLOBs> selectByExampleWithBLOBs(NodePaymentExample example);

    List<NodePayment> selectByExample(NodePaymentExample example);

    NodePaymentWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NodePaymentWithBLOBs record, @Param("example") NodePaymentExample example);

    int updateByExampleWithBLOBs(@Param("record") NodePaymentWithBLOBs record, @Param("example") NodePaymentExample example);

    int updateByExample(@Param("record") NodePayment record, @Param("example") NodePaymentExample example);

    int updateByPrimaryKeySelective(NodePaymentWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(NodePaymentWithBLOBs record);

    int updateByPrimaryKey(NodePayment record);

    Double queryMoneyByDate(NodePaymentExample example);
}