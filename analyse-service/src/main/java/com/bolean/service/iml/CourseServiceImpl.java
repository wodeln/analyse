package com.bolean.service.iml;

import com.bolean.dao.CourseMapper;
import com.bolean.entity.Course;
import com.bolean.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Map;

public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> selectAll() {
        return courseMapper.selectAll();
    }

    @Override
    public List<Course> select(Course course) {
        return courseMapper.select(course);
    }

    @Override
    public Course selectByPrimaryKey(Long id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public Course selectOne(Course course) {
        return courseMapper.selectOne(course);
    }

    @Override
    public int insert(Course course) {
        return courseMapper.insert(course);
    }

    @Override
    public int insertSelective(Course course) {
        return 0;
    }

    @Override
    public int insertList(List<Course> courses) {
        return courseMapper.insertList(courses);
    }

    @Override
    public int updateByPrimaryKey(Course course) {
        return courseMapper.updateByPrimaryKey(course);
    }

    @Override
    public int updateByPrimaryKeySelective(Course course) {
        return 0;
    }

    @Override
    public int selectCount(Course course) {
        return courseMapper.selectCount(course);
    }

    @Override
    public List<Course> selectByInfo(Map<String, Object> map) {
        return courseMapper.selectByInfo(map);
    }

    @Override
    public List<Course> selectByInfo(Course course) {
        return courseMapper.selectByInfo(course);
    }
}
