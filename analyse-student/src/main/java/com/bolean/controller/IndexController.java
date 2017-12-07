package com.bolean.controller;


import com.bolean.entity.User;
import com.bolean.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dell on 2017/11/21.
 */
@RestController
@RequestMapping("user")
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public  String index(){
        return "hello  world";
    }


    @RequestMapping("getAllUser")
    public void getAllUser(){
        PageHelper.startPage(1, 5);
        List<User> users=userService.getAllUser();
//        PageInfo
        System.out.println("-----------"+users);
    }
}
