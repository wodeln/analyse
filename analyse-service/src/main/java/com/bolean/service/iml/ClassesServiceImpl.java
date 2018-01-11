package com.bolean.service.iml;

import com.bolean.dao.ClassesMapper;
import com.bolean.entity.Classes;
import com.bolean.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public List<Classes> selectAll() {
        return classesMapper.selectAll();
    }

    @Override
    public List<Classes> select(Classes classes) {
        return classesMapper.select(classes);
    }

    @Override
    public Classes selectByPrimaryKey(Long id) {
        return classesMapper.selectByPrimaryKey(id);
    }

    @Override
    public Classes selectOne(Classes classes) {
        return classesMapper.selectOne(classes);
    }

    @Override
    public int insert(Classes classes) {
        return classesMapper.insert(classes);
    }

    @Override
    public int insertSelective(Classes classes) {
        return 0;
    }

    @Override
    public int insertList(List<Classes> classes) {
        return classesMapper.insertList(classes);
    }

    @Override
    public int updateByPrimaryKey(Classes classes) {
        return classesMapper.updateByPrimaryKey(classes);
    }

    @Override
    public int updateByPrimaryKeySelective(Classes classes) {
        return 0;
    }

    @Override
    public int selectCount(Classes classes) {
        return classesMapper.selectCount(classes);
    }

    @Override
    public List<Classes> selectByInfo(Map<String, Object> map) {
        return classesMapper.selectByInfo(map);
    }

    @Override
    public List<Classes> selectByInfo(Classes classes) {
        return classesMapper.selectByInfo(classes);
    }
}
