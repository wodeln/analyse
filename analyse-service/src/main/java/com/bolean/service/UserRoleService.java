package com.bolean.service;

import com.bolean.entity.UserRole;

import java.util.List;
import java.util.Map;

public interface UserRoleService extends BaseService<UserRole> {
    public List<UserRole> selectByMap(Map<String, Object> map);

    List<UserRole> selectInfoByUserRole(UserRole userRole);
}
