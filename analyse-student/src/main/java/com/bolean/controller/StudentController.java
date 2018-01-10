package com.bolean.controller;

import bolean.RSTFul.RSTFulBody;
import com.bolean.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student")
public class StudentController extends BaseController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/index.html")
    public String index(){
        return "/student/index.html";
    }

    @ResponseBody
    @RequestMapping("ajax_index")
    public RSTFulBody ajaxIndex(){
        return null;
    }

    @RequestMapping("add_student.html")
    public String addUI(){
        return "/student/add_student.html";
    }

    @ResponseBody
    @RequestMapping("add_student")
    public RSTFulBody addStudent(){
        return null;
    }

    @RequestMapping("edit_student.html")
    public String editUI(){
        return "student/edit_student.html";
    }

    @ResponseBody
    @RequestMapping("edit_student")
    public RSTFulBody editStudent(){
        return null;
    }

    @RequestMapping("del_student")
    public RSTFulBody delStudent(){
        return null;
    }
}
