package com.bolean.service.iml;

import com.bolean.dao.UserMapper;
import com.bolean.entity.User;
import com.bolean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> select(User user) {
        return userMapper.select(user);
    }

    @Override
    public User selectByPrimaryKey(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User selectOne(User user) {
        return userMapper.selectOne(user);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int insertList(List<User> users) {
        return userMapper.insertList(users);
    }

    @Override
    public int updateByPrimaryKey(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int selectCount(User user) {
        return userMapper.selectCount(user);
    }

    @Override
    public List<User> selectByExample(Example example){
        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> selectByInfo(Map<String, Object> map) {
        return userMapper.selectByInfo(map);
    }

    @Override
    public List<User> selectByInfo(User user) {
        return userMapper.selectByInfo(user);
    }
}
