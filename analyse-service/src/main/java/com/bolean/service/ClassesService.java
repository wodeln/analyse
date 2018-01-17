package com.bolean.service;

import com.bolean.entity.Classes;
import com.bolean.entity.Grade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ClassesService extends BaseService<Classes> {
    List<Classes> selectByInfo(Map<String, Object> map);

    List<Classes> selectByInfo(Classes classes);

    int selectCountByGradeIds(String gradeIds);

    List<Grade> selectGradeByIds(String gradeIds);

    List<Grade> selectAllGrade();
}
