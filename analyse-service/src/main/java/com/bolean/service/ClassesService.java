package com.bolean.service;

import com.bolean.entity.Classes;

import java.util.List;
import java.util.Map;

public interface ClassesService extends BaseService<Classes> {
    List<Classes> selectByMap(Map<String, Object> map);

    List<Classes> selectByClasses(Classes classes);
}
