package com.bolean.service.iml;

import com.bolean.dao.GuardianMapper;
import com.bolean.entity.Guardian;
import com.bolean.service.GuardianService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Map;

public class GuardianServiceImpl implements GuardianService {
    @Autowired
    private GuardianMapper guardianMapper;

    @Override
    public List<Guardian> selectAll() {
        return guardianMapper.selectAll();
    }

    @Override
    public List<Guardian> select(Guardian guardian) {
        return guardianMapper.select(guardian);
    }

    @Override
    public Guardian selectByPrimaryKey(long id) {
        return guardianMapper.selectByPrimaryKey(id);
    }

    @Override
    public Guardian selectOne(Guardian guardian) {
        return guardianMapper.selectOne(guardian);
    }

    @Override
    public int insert(Guardian guardian) {
        return guardianMapper.insert(guardian);
    }

    @Override
    public int insertSelective(Guardian guardian) {
        return 0;
    }

    @Override
    public int insertList(List<Guardian> guardians) {
        return guardianMapper.insertList(guardians);
    }

    @Override
    public int updateByPrimaryKey(Guardian guardian) {
        return 0;
    }

    @Override
    public int selectCount(Guardian guardian) {
        return guardianMapper.selectCount(guardian);
    }

    @Override
    public List<Guardian> selectByInfo(Map<String, Object> map) {
        return guardianMapper.selectByInfo(map);
    }

    @Override
    public List<Guardian> selectByInfo(Guardian guardian) {
        return guardianMapper.selectByInfo(guardian);
    }
}
