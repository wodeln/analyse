package com.bolean.dao;


import com.bolean.entity.Classes;
import com.bolean.entity.Grade;
import mybatis.basemapper.BaseMapper;

import java.util.List;

public interface ClassesMapper extends BaseMapper<Classes> {
    int selectCountByGradeIds(String gradeIds);

    List<Grade> selectGradeByIds(String gradeIds);

    List<Grade> selectAllGrade();
}