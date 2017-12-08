package com.bolean.service;


import com.bolean.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService extends BaseService<User>{
    List<User> selectByMap(Map<String, Object> map);

    List<User> selectByUser(User user);
}
