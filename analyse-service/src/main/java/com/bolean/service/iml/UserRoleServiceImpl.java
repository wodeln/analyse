package com.bolean.service.iml;

import com.bolean.dao.UserRoleMapper;
import com.bolean.entity.UserRole;
import com.bolean.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;


    @Override
    public List<UserRole> selectAll() {
        return userRoleMapper.selectAll();
    }

    @Override
    public List<UserRole> select(UserRole userRole) {
        return userRoleMapper.select(userRole);
    }

    @Override
    public UserRole selectByPrimaryKey(long id) {
        return userRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserRole selectOne(UserRole userRole) {
        return userRoleMapper.selectOne(userRole);
    }

    @Override
    public int insert(UserRole userRole) {
        return userRoleMapper.insert(userRole);
    }

    @Override
    public int insertList(List<UserRole> userRoles) {
        return userRoleMapper.insertList(userRoles);
    }

    @Override
    public int updateByPrimaryKey(UserRole userRole) {
        return userRoleMapper.updateByPrimaryKey(userRole);
    }

    @Override
    public int selectCount(UserRole userRole) {
        return userRoleMapper.selectCount(userRole);
    }

    @Override
    public List<UserRole> selectByExample(Example example) {
        return userRoleMapper.selectByExample(example);
    }

    @Override
    public List<UserRole> selectByMap(Map<String, Object> map) {
        return userRoleMapper.selectByMap(map);
    }

    @Override
    public List<UserRole> selectInfoByUserRole(UserRole userRole) {
        return userRoleMapper.selectInfoByUserRole(userRole);
    }
}
