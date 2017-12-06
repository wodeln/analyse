package com.bolean.service.iml;

import com.bolean.dao.UserMapper;
import com.bolean.entity.User;
import com.bolean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> getAllUser() {
        return userMapper.getAll();
//        return null;
    }

    /*@Autowired
    private UserDao userDao;*/
}
