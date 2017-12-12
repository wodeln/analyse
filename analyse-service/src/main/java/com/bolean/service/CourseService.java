package com.bolean.service;

import com.bolean.entity.Course;

import java.util.List;
import java.util.Map;

public interface CourseService extends BaseService<Course> {
    List<Course> selectByInfo(Map<String,Object> map);

    List<Course> selectByInfo(Course course);
}
