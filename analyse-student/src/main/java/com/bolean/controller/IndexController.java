package com.bolean.controller;


import com.bolean.entity.User;
import com.bolean.entity.UserExample;
import com.bolean.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dell on 2017/11/21.
 */
@Controller
//@RequestMapping("user")
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public  String index(){
        return "hello  world";
    }

    /**
     * 获取用户列表
     * @param
     * @return
     */
    @ApiOperation(value="获取用户列表", notes="分页获取用户列表")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping("getAllUser")
    public void getAllUser(){
        PageHelper.startPage(1, 5);
        /*List<User> users=userService.getAllUser();
//        PageInfo
        System.out.println("-----------"+users);*/
    }

    @RequestMapping("beetl.html")
    public String beetlTest(Model model){
        model.addAttribute("name","hello,world");
        return "/beetl.html";
    }

    @RequestMapping("example.html")
    public String selectByExample(){
        UserExample example=new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andRealNameLike("zhaoyan");
        User user = new User();
        userService.select(user);
        return "";
    }
}
