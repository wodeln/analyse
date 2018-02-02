package com.bolean.controller;

import bolean.RSTFul.RSTFulBody;
import com.bolean.entity.Classes;
import com.bolean.entity.Grade;
import com.bolean.entity.Student;
import com.bolean.entity.User;
import com.bolean.service.ClassesService;
import com.bolean.service.StudentService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import utils.DateHelper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

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

    @RequestMapping("ajax_index")
    public String ajaxIndex(Model model, int pageNum, int pageSize,
                                @RequestParam(required = false) String className,
                                @RequestParam(required = false) String classYear,
                                @RequestParam(required = false) String gradeId){

        List<Grade> grades = new ArrayList<>();
        if(gradeId!=null && gradeId!="") grades = makeGradeStudentTree(classesService.selectGradeByIds(gradeId),classYear);
        else grades = makeGradeStudentTree(classesService.selectAllGrade(),classYear);
        model.addAttribute("grades",grades);
        //分页查询
       /*PageHelper.startPage(pageNum, pageSize);
        List<Classes> classes = classesService.selectByInfo(map);
        PageInfo<Classes> pageInfo = new PageInfo<>(classes);

        String pageStr = makePageHtml(pageInfo);
        model.addAttribute("page_info",pageInfo);
        model.addAttribute("pages",pageStr);*/
        return "/student/ajax_index.html";
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
    public RSTFulBody addStudent(Student student){

        User sessionUser = getSessionUser();
        student.setCreateName(sessionUser.getRealName());
        student.setCreateId(sessionUser.getUserId());
        int res=studentService.insertSelective(student);

        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success("添加成功！");
        else  rstFulBody.fail("添加失败！");
        return rstFulBody;
    }

    @RequestMapping("batch_add_student.html")
    public String batchAddStudentUI(Model model){

        String curYear = getCurrentYear()+"";
        List<Grade> grades = makeGradeTree(classesService.selectAllGrade(),curYear);

        model.addAttribute("grades",grades);
        model.addAttribute("cur_year",curYear+"学年");
        return "/student/batch_add_student.html";
    }

    @ResponseBody
    @RequestMapping("batch_add_student")
    public RSTFulBody batchAddStudent(
                                    @RequestParam(value="studentName[]") String[] studentName,
                                    @RequestParam(value="classId[]") String[] classId,
                                    @RequestParam(value="studentCardNum[]") String[] studentCardNum,
                                    @RequestParam(value="studentAge[]") String[] studentAge,
                                    @RequestParam(value="studentSex[]") String[] studentSex,
                                    @RequestParam(value="studentCode[]") String[] studentCode,
                                    @RequestParam(value="studentAliId[]") String[] studentAliId,
                                    @RequestParam(value="province[]") String[] province,
                                    @RequestParam(value="district[]") String[] district,
                                    @RequestParam(value="address[]") String[] address,
                                    @RequestParam(value="contactName[]") String[] contactName,
                                    @RequestParam(value="contactNum[]") String[] contactNum,
                                    @RequestParam(value="nowAddress[]") String[] nowAddress
    ){
//        String[] students = request.getParameterValues("studentName[]");
        User sessionUser = getSessionUser();
        List<Student> students = new ArrayList<>();
        for(int i=0;i<studentName.length;i++){
            Student student = new Student();
            student.setStudentName(studentName[i]);
            student.setClassId((long)Integer.parseInt(classId[i]));
            student.setStudentCardNum(studentCardNum.length==0?null:studentCardNum[i]);
            student.setStudentAge(studentAge.length==0 || studentAge[i]=="" ?null:Integer.valueOf(studentAge[i]));
            student.setStudentSex(Integer.parseInt(studentSex[i]));
            student.setStudentCode(studentCode.length==0?null:studentCode[i]);
            student.setStudentAliId(studentAliId.length==0 || studentAliId[i]=="" ?null:Long.valueOf(studentAliId[i]));
            student.sethProvince(province.length==0?null:province[i]);
            student.sethDistrict(district.length==0?null:district[i]);
            student.sethAddress(address.length==0?null:address[i]);
            student.setContactName(contactName.length==0?null:contactName[i]);
            student.setContactNum(contactNum.length==0?null:contactNum[i]);
            student.setNowAddress(nowAddress.length==0?null:nowAddress[i]);
            student.setCreateName(sessionUser.getRealName());
            student.setCreateId(sessionUser.getUserId());
            student.setStatus(2);
            students.add(student);
        }
        int res = studentService.insertList(students);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success("添加成功！");
        else  rstFulBody.fail("添加失败！");
        return rstFulBody;
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

    @ResponseBody
    @RequestMapping("/import_excel.html")
    public Map<String,Object> importExcel(MultipartFile file) throws IOException {

        Map<String,Object> stateMap = upload(file);
        Map<String,Object> result = new HashMap<>();
        if(stateMap.get("status") == "1") {
            List<Student> students = new ArrayList<>();
            Workbook book = null;
            try {
                book = new XSSFWorkbook(new FileInputStream(ResourceUtils.getFile(stateMap.get("fileInfo")+"")));
            } catch (Exception ex) {
                book = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile(stateMap.get("fileInfo")+"")));
            }
//
            Sheet sheet = book.getSheetAt(0);
            for(int i=2; i<sheet.getLastRowNum()+1; i++) {
                Row row = sheet.getRow(i);
                Cell ii = row.getCell(0);
                System.out.println("");
            }
            System.out.println("");
        }
        return null;
    }

    private List<Grade> makeGradeStudentTree(List<Grade> grades,String classYear){
        for(int i=0;i<grades.size();i++){
            Map<String,Object> tempMap = new HashMap<>();
            tempMap.put("classYear",classYear);
            tempMap.put("gradeId",grades.get(i).getGradeId());
            tempMap.put("status",2);
            List<Classes> classes = classesService.selectByInfo(tempMap);
            if(classes.size()>0) {
                grades.get(i).setClasses(classes);
                for(int j=0;j<classes.size();j++){
                    /*Student student = new Student();
                    student.setClassId(classes.get(j).getClassId());*/
                    Map<String,Object> map = new HashMap<>();
                    map.put("classId",classes.get(j).getClassId());
                    List<Student> students = studentService.selectByInfo(map);
                    if(students.size()>0) classes.get(j).setStudents(students);
                }
            }
        }
        return grades;
    }
}
