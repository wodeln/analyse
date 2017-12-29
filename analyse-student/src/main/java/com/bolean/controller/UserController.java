package com.bolean.controller;

import bolean.RSTFul.RSTFulBody;
import com.bolean.entity.Role;
import com.bolean.entity.User;
import com.bolean.service.RoleService;
import com.bolean.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/index.html")
    public String getAllUser(Model model, HttpServletRequest request){

        //查询所有角色
        List<Role> roles = roleService.selectAll();

        model.addAttribute("roles",roles);
        return "/user/index.html";
    }

    @RequestMapping("/ajax_index")
    public String ajaxIndex(Model model, HttpServletRequest request, int pageNum, int pageSize,
                            @RequestParam(required = false) String nut,
                            @RequestParam(required = false) String role
                            ){
//        int pageNum = Integer.parseInt(request.getParameter("pageNum"));
//        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        //组装搜索条件
        Map<String,Object> map=new HashMap<>();
        if(nut!=null) map.put("nut",nut);
        if(nut!="") map.put("role",role);
        //分页查询用户
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userService.selectByInfo(map);
        PageInfo<User> pageInfo= new PageInfo<>(users);
        String pageStr = makePageHtml(pageInfo);
        model.addAttribute("page_info",pageInfo);
        model.addAttribute("pages",pageStr);
        return "/user/ajax_index.html";
    }

    @RequestMapping("add_user.html")
    public String addUI(){
        return "/user/add_user.html";
    }

    @ResponseBody
    @RequestMapping("add_user")
    public RSTFulBody addUser(User user){
        User sessionUser = getSessionUser();
        user.setCreateName(sessionUser.getRealName());
        user.setCreateId(sessionUser.getUserId());
        int res=userService.insertSelective(user);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success("添加成功！");
        else  rstFulBody.fail("添加失败！");
        return rstFulBody;
    }

    @RequestMapping("edit_user.html")
    public String editUI(Model model,String userId){
        User user = userService.selectByPrimaryKey(Integer.parseInt(userId));
        model.addAttribute("iuser",user);
        return "/user/edit_user.html";
    }

    @ResponseBody
    @RequestMapping("edit_user")
    public RSTFulBody editUser(User user){
        User sessionUser = getSessionUser();
        user.setUpdateId(sessionUser.getUserId());
        user.setUpdateName(sessionUser.getRealName());
        user.setUpdateTime(new Date());
        int res = userService.updateByPrimaryKeySelective(user);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success("修改成功！");
        else  rstFulBody.fail("修改失败！");
        return rstFulBody;
    }

    @RequestMapping("del_user.html")
    public String delUser(User user){
        User sessionUser = getSessionUser();
        user.setUpdateName(sessionUser.getRealName());
        user.setUpdateId(sessionUser.getUserId());
        user.setUpdateTime(new Date());
        user.setStatus(0);

        int res = userService.updateByPrimaryKeySelective(user);
        return "redirect:/user/index.html";
    }
}
