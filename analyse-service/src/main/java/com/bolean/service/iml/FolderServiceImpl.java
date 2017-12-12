package com.bolean.service.iml;

import com.bolean.dao.FolderMapper;
import com.bolean.entity.Folder;
import com.bolean.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class FolderServiceImpl implements FolderService {
    @Autowired
    private FolderMapper folderMapper;

    @Override
    public List<Folder> selectAll() {
        return folderMapper.selectAll();
    }

    @Override
    public List<Folder> select(Folder folder) {
        return folderMapper.select(folder);
    }

    @Override
    public Folder selectByPrimaryKey(long id) {
        return folderMapper.selectByPrimaryKey(id);
    }

    @Override
    public Folder selectOne(Folder folder) {
        return folderMapper.selectOne(folder);
    }

    @Override
    public int insert(Folder folder) {
        return folderMapper.insert(folder);
    }

    @Override
    public int insertList(List<Folder> folders) {
        return folderMapper.insertList(folders);
    }

    @Override
    public int updateByPrimaryKey(Folder folder) {
        return folderMapper.updateByPrimaryKey(folder);
    }

    @Override
    public int selectCount(Folder folder) {
        return folderMapper.selectCount(folder);
    }

    @Override
    public List<Folder> selectByExample(Example example) {
        return folderMapper.selectByExample(example);
    }
}
