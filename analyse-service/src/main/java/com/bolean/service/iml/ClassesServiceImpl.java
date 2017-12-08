package com.bolean.service.iml;

import com.bolean.dao.ClassesMapper;
import com.bolean.entity.Classes;
import com.bolean.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

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
    public Classes selectByPrimaryKey(long id) {
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
    public int insertList(List<Classes> classes) {
        return classesMapper.insertList(classes);
    }

    @Override
    public int updateByPrimaryKey(Classes classes) {
        return classesMapper.updateByPrimaryKey(classes);
    }

    @Override
    public int selectCount(Classes classes) {
        return classesMapper.selectCount(classes);
    }

    @Override
    public List<Classes> selectByExample(Example example) {
        return classesMapper.selectByExample(example);
    }

    @Override
    public List<Classes> selectByMap(Map<String, Object> map) {
        return classesMapper.selectByMap(map);
    }
}
