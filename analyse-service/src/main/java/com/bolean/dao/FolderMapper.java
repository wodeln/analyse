package com.bolean.dao;

import com.bolean.entity.Folder;
import com.bolean.entity.FolderExample;

import java.util.List;

public interface FolderMapper {
    long countByExample(FolderExample example);

    int deleteByExample(FolderExample example);

    int deleteByPrimaryKey(Integer folderId);

    int insert(Folder record);

    int insertSelective(Folder record);

    List<Folder> selectByExample(FolderExample example);

    Folder selectByPrimaryKey(Integer folderId);

    int updateByPrimaryKeySelective(Folder record);

    int updateByPrimaryKey(Folder record);
}