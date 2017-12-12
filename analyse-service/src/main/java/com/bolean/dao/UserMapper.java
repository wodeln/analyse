package com.bolean.dao;

import com.bolean.entity.User;
import mybatis.basemapper.BaseMapper;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> selectByInfo(Object o);
}