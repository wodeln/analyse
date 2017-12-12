package com.bolean.service.iml;

import com.bolean.dao.CourseTeacherMapper;
import com.bolean.entity.CourseTeacher;
import com.bolean.service.CourseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class CourseTeacherServiceImpl implements CourseTeacherService {
    @Autowired
    private CourseTeacherMapper courseTeacherMapper;

    @Override
    public List<CourseTeacher> selectAll() {
        return courseTeacherMapper.selectAll();
    }

    @Override
    public List<CourseTeacher> select(CourseTeacher courseTeacher) {
        return courseTeacherMapper.select(courseTeacher);
    }

    @Override
    public CourseTeacher selectByPrimaryKey(long id) {
        return courseTeacherMapper.selectByPrimaryKey(id);
    }

    @Override
    public CourseTeacher selectOne(CourseTeacher courseTeacher) {
        return courseTeacherMapper.selectOne(courseTeacher);
    }

    @Override
    public int insert(CourseTeacher courseTeacher) {
        return courseTeacherMapper.insert(courseTeacher);
    }

    @Override
    public int insertList(List<CourseTeacher> courseTeachers) {
        return courseTeacherMapper.insertList(courseTeachers);
    }

    @Override
    public int updateByPrimaryKey(CourseTeacher courseTeacher) {
        return courseTeacherMapper.updateByPrimaryKey(courseTeacher);
    }

    @Override
    public int selectCount(CourseTeacher courseTeacher) {
        return courseTeacherMapper.selectCount(courseTeacher);
    }

    @Override
    public List<CourseTeacher> selectByExample(Example example) {
        return courseTeacherMapper.selectByExample(example);
    }
}