package com.bolean.controller;

import com.bolean.entity.User;
import com.bolean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/get_all_user.html")
    public String getAllUser(){

        List<User> users = userService.selectAll();
        return "user_list.html";
    }

    @RequestMapping("/addUser")
    public void insert(User user){
        int userId = userService.insert(user);
    }

    @RequestMapping("updateUser")
    public void update(User user){
        int userId = userService.updateByPrimaryKey(user);
    }
}
