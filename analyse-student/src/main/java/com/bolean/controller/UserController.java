package com.bolean.controller;

import com.bolean.entity.User;
import com.bolean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @RequestMapping("/get_all_user.html")
    public String getAllUser(){

        List<User> users = userService.selectAll();
        return "user_list.html";
    }

    @RequestMapping("/add_user.html")
    public String insert(User user){
        User sessionUser = getSessionUser();
        user.setCreateId(sessionUser.getUserId());
        user.setCreateName(sessionUser.getRealName());
        user.setCreateTime(new Date());
        int userId = userService.insert(user);
        if(userId>0) return "成功";
        else return "失败";
    }

    @RequestMapping("updateUser")
    public void update(User user){
        int userId = userService.updateByPrimaryKey(user);
    }
}
