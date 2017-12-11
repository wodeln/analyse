package com.bolean.service;

import com.bolean.entity.UserRole;

import java.util.List;
import java.util.Map;

public interface UserRoleService extends BaseService<UserRole> {
    List<UserRole> selectByInfo(Map<String, Object> map);

    List<UserRole> selectByInfo(UserRole userRole);
}
