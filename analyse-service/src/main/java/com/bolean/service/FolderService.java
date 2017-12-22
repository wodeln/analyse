package com.bolean.service;

import com.bolean.entity.Folder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FolderService extends BaseService<Folder> {
    List<Folder> selectByParentId(Integer parentId);
}
