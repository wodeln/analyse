package com.bolean.dao;

import com.bolean.entity.User;
import com.bolean.entity.UserExample;
import mybatis.basemapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {
    List<User> selectByMap(Map<String,Object> map);

    List<User> selectByRole(User user);
}