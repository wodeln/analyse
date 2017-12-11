package com.bolean.service;

import com.bolean.entity.RoleFolder;

import java.util.List;
import java.util.Map;

public interface RoleFolderService extends BaseService<RoleFolder> {
    List<RoleFolder> selectByInfo(Map<String,Object> map);

    List<RoleFolder> selectByInfo(RoleFolder roleFolder);
}
