package com.bolean.dao;

import com.bolean.entity.CourseTeacher;
import com.bolean.entity.CourseTeacherExample;

import java.util.List;

public interface CourseTeacherMapper {
    long countByExample(CourseTeacherExample example);

    int deleteByExample(CourseTeacherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CourseTeacher record);

    int insertSelective(CourseTeacher record);

    List<CourseTeacher> selectByExample(CourseTeacherExample example);

    CourseTeacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseTeacher record);

    int updateByPrimaryKey(CourseTeacher record);
}