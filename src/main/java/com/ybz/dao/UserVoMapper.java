package com.ybz.dao;

import com.ybz.entity.UserVo;
import com.ybz.entity.UserVoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserVoMapper {
    int countByExample(UserVoExample example);

    int deleteByExample(UserVoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserVo record);

    int insertSelective(UserVo record);

    List<UserVo> selectByExample(UserVoExample example);

    UserVo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserVo record, @Param("example") UserVoExample example);

    int updateByExample(@Param("record") UserVo record, @Param("example") UserVoExample example);

    int updateByPrimaryKeySelective(UserVo record);

    int updateByPrimaryKey(UserVo record);

    int insertUserVoBatch(List<UserVo> userVoList);
}