package com.bolean.controller;

import com.bolean.entity.Folder;
import com.bolean.entity.Student;
import com.bolean.entity.User;
import com.bolean.entity.UserExample;
import com.bolean.service.FolderService;
import com.bolean.service.StudentService;
import com.bolean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by dell on 2017/11/21.
 */
@Controller
public class IndexController{

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private FolderService folderService;

    @RequestMapping("/")
    public  String index(Model model){
        //获取所有顶级菜单
        List<Folder> folders=folderService.selectByParentId(0);
        /*for (Folder folder : folders) {
            
        }*/
        for (int i = 0; i < folders.size(); i++) {
            List<Folder> childFolders = folderService.selectByParentId(folders.get(i).getFolderId());
            if(childFolders.size()>0) folders.get(i).setChildFolders(childFolders);
        }
        model.addAttribute("menus",folders);
        //        folderService.select();
        return "/index.html";
    }

    /**
     * 获取用户列表
     * @param
     * @return
     */
   /* @ApiOperation(value="获取用户列表", notes="分页获取用户列表")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping("getAllUser")
    public void getAllUser(){
        PageHelper.startPage(1, 5);
        *//*List<User> users=userService.getAllUser();
//        PageInfo
        System.out.println("-----------"+users);*//*
    }*/

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
        Student student = new Student();
        student.setClassId(1);
//        studentService
        return "";
    }
}
