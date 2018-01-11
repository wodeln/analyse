package com.bolean.service.iml;

import com.bolean.dao.ClassUserMapper;
import com.bolean.entity.ClassUser;
import com.bolean.service.ClassUserService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class ClassUserServiceImpl implements ClassUserService {
    @Autowired
    private ClassUserMapper classUserMapper;

    @Override
    public List<ClassUser> selectAll() {
        return classUserMapper.selectAll();
    }

    @Override
    public List<ClassUser> select(ClassUser classUser) {
        return classUserMapper.select(classUser);
    }

    @Override
    public ClassUser selectByPrimaryKey(Long id) {
        return classUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public ClassUser selectOne(ClassUser classUser) {
        return classUserMapper.selectOne(classUser);
    }

    @Override
    public int insert(ClassUser classUser) {
        return classUserMapper.insert(classUser);
    }

    @Override
    public int insertSelective(ClassUser classUser) {
        return 0;
    }

    @Override
    public int insertList(List<ClassUser> classUsers) {
        return classUserMapper.insertList(classUsers);
    }

    @Override
    public int updateByPrimaryKey(ClassUser classUser) {
        return classUserMapper.updateByPrimaryKey(classUser);
    }

    @Override
    public int updateByPrimaryKeySelective(ClassUser classUser) {
        return 0;
    }

    @Override
    public int selectCount(ClassUser classUser) {
        return selectCount(classUser);
    }

}
