package com.bolean.dao;

import com.bolean.entity.RoleFolder;
import com.bolean.entity.RoleFolderExample;

import java.util.List;

public interface RoleFolderMapper {
    long countByExample(RoleFolderExample example);

    int deleteByExample(RoleFolderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RoleFolder record);

    int insertSelective(RoleFolder record);

    List<RoleFolder> selectByExample(RoleFolderExample example);

    RoleFolder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoleFolder record);

    int updateByPrimaryKey(RoleFolder record);
}