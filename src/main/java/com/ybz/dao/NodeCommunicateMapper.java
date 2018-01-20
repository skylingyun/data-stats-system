package com.ybz.dao;

import com.ybz.entity.NodeCommunicate;
import com.ybz.entity.NodeCommunicateExample;
import com.ybz.entity.NodeCommunicateWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface NodeCommunicateMapper {
    int countByExample(NodeCommunicateExample example);

    int deleteByExample(NodeCommunicateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NodeCommunicateWithBLOBs record);

    int insertSelective(NodeCommunicateWithBLOBs record);

    List<NodeCommunicateWithBLOBs> selectByExampleWithBLOBs(NodeCommunicateExample example);

    List<NodeCommunicate> selectByExample(NodeCommunicateExample example);

    NodeCommunicateWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NodeCommunicateWithBLOBs record, @Param("example") NodeCommunicateExample example);

    int updateByExampleWithBLOBs(@Param("record") NodeCommunicateWithBLOBs record, @Param("example") NodeCommunicateExample example);

    int updateByExample(@Param("record") NodeCommunicate record, @Param("example") NodeCommunicateExample example);

    int updateByPrimaryKeySelective(NodeCommunicateWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(NodeCommunicateWithBLOBs record);

    int updateByPrimaryKey(NodeCommunicate record);

    Double queryMoneyByDate(NodeCommunicateExample example);
}