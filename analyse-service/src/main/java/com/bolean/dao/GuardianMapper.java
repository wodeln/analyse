package com.bolean.dao;


import com.bolean.entity.Guardian;
import com.bolean.entity.GuardianExample;
import org.jboss.logging.Param;

import java.util.List;

public interface GuardianMapper {
    long countByExample(GuardianExample example);

    int deleteByExample(GuardianExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Guardian record);

    int insertSelective(Guardian record);

    List<Guardian> selectByExample(GuardianExample example);

    Guardian selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Guardian record);

    int updateByPrimaryKey(Guardian record);
}