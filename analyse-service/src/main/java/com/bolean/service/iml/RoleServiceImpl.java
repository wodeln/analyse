package com.bolean.service.iml;

import com.bolean.dao.RoleMapper;
import com.bolean.entity.Role;
import com.bolean.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }

    @Override
    public List<Role> select(Role role) {
        return roleMapper.select(role);
    }

    @Override
    public Role selectByPrimaryKey(long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Role selectOne(Role role) {
        return roleMapper.selectOne(role);
    }

    @Override
    public int insert(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int insertList(List<Role> roles) {
        return roleMapper.insertList(roles);
    }

    @Override
    public int updateByPrimaryKey(Role role) {
        return updateByPrimaryKey(role);
    }

    @Override
    public int selectCount(Role role) {
        return roleMapper.selectCount(role);
    }

    @Override
    public List<Role> selectByExample(Example example) {
        return roleMapper.selectByExample(example);
    }

    @Override
    public List<Role> selectByInfo(Map<String, Object> map) {
        return roleMapper.selectByInfo(map);
    }

    @Override
    public List<Role> selectByInfo(Role role) {
        return roleMapper.selectByInfo(role);
    }
}
