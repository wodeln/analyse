package com.bolean.dao;

import com.bolean.entity.UserRole;
import com.bolean.entity.UserRoleExample;
import mybatis.basemapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface UserRoleMapper extends BaseMapper<UserRole>{
    List<UserRole> selectByMap(Map<String,Object> map);

    List<UserRole> selectInfoByUserRole(UserRole userRole);
}