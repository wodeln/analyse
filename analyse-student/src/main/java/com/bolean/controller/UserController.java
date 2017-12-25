package com.bolean.controller;

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

    @RequestMapping("pagetest")
    public void pagetest(){
        User user = new User();
        for (int i=0;i<10000;i++){
            user.setUserName(i+"");
            user.setPassword("1");
            userService.insertSelective(user);
        }
    }
}
