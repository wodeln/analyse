package com.bolean.service;

import com.bolean.entity.Role;

import java.util.List;
import java.util.Map;

public interface RoleService extends BaseService<Role> {
    List<Role> selectByMap(Map<String, Object> map);

    List<Role> selectByRole(Role role);
}
