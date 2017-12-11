package com.bolean.service;

import com.bolean.entity.Role;

import java.util.List;
import java.util.Map;

public interface RoleService extends BaseService<Role> {
    List<Role> selectByInfo(Map<String, Object> map);

    List<Role> selectByInfo(Role role);
}
