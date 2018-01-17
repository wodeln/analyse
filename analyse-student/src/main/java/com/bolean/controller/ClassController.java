package com.bolean.controller;

import bolean.RSTFul.RSTFulBody;
import com.bolean.entity.Classes;
import com.bolean.entity.Grade;
import com.bolean.entity.User;
import com.bolean.service.ClassesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import static utils.DateHelper.getCurrentYear;

@Controller
@RequestMapping("/class")
public class ClassController extends BaseController{
    @Autowired
    private ClassesService classesService;

    @RequestMapping("/index.html")
    public String index(Model model){
        String curYear = getCurrentYear()+"学年";
        model.addAttribute("curYear",curYear);
        return "/class/index.html";
    }


    @RequestMapping("ajax_index")
    public String ajaxIndex(Model model, int pageNum, int pageSize,
                            @RequestParam(required = false) String className,
                            @RequestParam(required = false) String classYear,
                            @RequestParam(required = false) String gradeId){
        //组装搜索条件

//        classYear = classYear == "" ? new String("Y") : classYear;

        Map<String,Object> map=new HashMap<>();
        map.put("status",2);
        map.put("classYear",classYear);
        if(className!=null && className!="") map.put("className",className);
        if(gradeId!=null && gradeId!="") map.put("gradeId",gradeId);

//        classesService.sel
        List<Grade> grades = new ArrayList<>();
        if(gradeId!=null && gradeId!="") grades = classesService.selectGradeByIds(gradeId);
        else grades = classesService.selectAllGrade();
        for(int i=0;i<grades.size();i++){
            Map<String,Object> tempMap = new HashMap<>();
            tempMap.put("classYear",classYear);
            tempMap.put("gradeId",grades.get(i).getGradeId());
            List<Classes> classes = classesService.selectByInfo(tempMap);
            if(classes.size()>0) grades.get(i).setClasses(classes);

        }

        model.addAttribute("grades",grades);
        //分页查询
       /*PageHelper.startPage(pageNum, pageSize);
        List<Classes> classes = classesService.selectByInfo(map);
        PageInfo<Classes> pageInfo = new PageInfo<>(classes);

        String pageStr = makePageHtml(pageInfo);
        model.addAttribute("page_info",pageInfo);
        model.addAttribute("pages",pageStr);*/
        return "/class/ajax_index.html";
    }

    @RequestMapping("add_class.html")
    public String addUI(Model model){
        /*List<Role> roles = roleService.selectAll();

        model.addAttribute("roles",roles);*/
        return "/class/add_class.html";
    }

    @ResponseBody
    @RequestMapping("add_class")
    public RSTFulBody addUser(Classes classes){
        User sessionUser = getSessionUser();
        classes.setCreateName(sessionUser.getRealName());
        classes.setCreateId(sessionUser.getUserId());
        int res=classesService.insertSelective(classes);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success("添加成功！");
        else  rstFulBody.fail("添加失败！");
        return rstFulBody;
    }
}
