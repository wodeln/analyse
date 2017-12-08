package com.bolean.dao;

import com.bolean.entity.Role;
import mybatis.basemapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface RoleMapper extends BaseMapper<Role> {
    List<Role> selectByMap(Map<String,Object> map);

    List<Role> selectByRole(Role role);
}