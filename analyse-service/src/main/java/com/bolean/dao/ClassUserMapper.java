package com.bolean.dao;


import com.bolean.entity.ClassUser;
import com.bolean.entity.ClassUserExample;

import java.util.List;

public interface ClassUserMapper {
    long countByExample(ClassUserExample example);

    int deleteByExample(ClassUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassUser record);

    int insertSelective(ClassUser record);

    List<ClassUser> selectByExample(ClassUserExample example);

    ClassUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassUser record);

    int updateByPrimaryKey(ClassUser record);
}