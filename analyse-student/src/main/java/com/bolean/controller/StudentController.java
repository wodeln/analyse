package com.bolean.controller;

import bolean.RSTFul.RSTFulBody;
import com.bolean.entity.Classes;
import com.bolean.entity.Grade;
import com.bolean.service.ClassesService;
import com.bolean.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.DateHelper;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.DateHelper.getCurrentYear;


@Controller
@RequestMapping("/student")
public class StudentController extends BaseController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassesService classesService;

    @RequestMapping("/index.html")
    public String index(Model model){
        String curYear = DateHelper.getCurrentYear()+"学年";

        model.addAttribute("curYear",curYear);
        return "/student/index.html";
    }

    @ResponseBody
    @RequestMapping("ajax_index")
    public RSTFulBody ajaxIndex(){
        return null;
    }

    @RequestMapping("add_student.html")
    public String addUI(Model model){
        String curYear = getCurrentYear()+"";
        List<Grade> grades = makeGradeTree(classesService.selectAllGrade(),curYear);

        model.addAttribute("grades",grades);
        model.addAttribute("cur_year",curYear+"学年");
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
