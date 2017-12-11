package com.bolean.service.iml;

import com.bolean.dao.RoleFolderMapper;
import com.bolean.entity.RoleFolder;
import com.bolean.service.RoleFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

public class RoleFolderServiceImpl implements RoleFolderService {
    @Autowired
    private RoleFolderMapper roleFolderMapper;

    @Override
    public List<RoleFolder> selectByInfo(Map<String, Object> map) {
        return roleFolderMapper.selectByInfo(map);
    }

    @Override
    public List<RoleFolder> selectByInfo(RoleFolder roleFolder) {
        return roleFolderMapper.selectByInfo(roleFolder);
    }

    @Override
    public List<RoleFolder> selectAll() {
        return roleFolderMapper.selectAll();
    }

    @Override
    public List<RoleFolder> select(RoleFolder roleFolder) {
        return roleFolderMapper.select(roleFolder);
    }

    @Override
    public RoleFolder selectByPrimaryKey(long id) {
        return roleFolderMapper.selectByPrimaryKey(id);
    }

    @Override
    public RoleFolder selectOne(RoleFolder roleFolder) {
        return roleFolderMapper.selectOne(roleFolder);
    }

    @Override
    public int insert(RoleFolder roleFolder) {
        return roleFolderMapper.insert(roleFolder);
    }

    @Override
    public int insertList(List<RoleFolder> roleFolders) {
        return roleFolderMapper.insertList(roleFolders);
    }

    @Override
    public int updateByPrimaryKey(RoleFolder roleFolder) {
        return roleFolderMapper.updateByPrimaryKey(roleFolder);
    }

    @Override
    public int selectCount(RoleFolder roleFolder) {
        return roleFolderMapper.selectCount(roleFolder);
    }

    @Override
    public List<RoleFolder> selectByExample(Example example) {
        return roleFolderMapper.selectByExample(example);
    }
}
