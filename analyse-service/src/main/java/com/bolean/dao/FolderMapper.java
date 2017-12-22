package com.bolean.dao;

import com.bolean.entity.Folder;
import mybatis.basemapper.BaseMapper;

import java.util.List;

public interface FolderMapper extends BaseMapper<Folder> {
    List<Folder> selectByParentId(Integer parentId);
}