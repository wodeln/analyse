package com.bolean.service.iml;

import com.bolean.dao.CourseTeacherMapper;
import com.bolean.entity.CourseTeacher;
import com.bolean.service.CourseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;


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
    public CourseTeacher selectByPrimaryKey(Long id) {
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
    public int insertSelective(CourseTeacher courseTeacher) {
        return 0;
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
    public int updateByPrimaryKeySelective(CourseTeacher courseTeacher) {
        return 0;
    }

    @Override
    public int selectCount(CourseTeacher courseTeacher) {
        return courseTeacherMapper.selectCount(courseTeacher);
    }

}
