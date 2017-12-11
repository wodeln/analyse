package com.bolean.service;

import com.bolean.entity.Guardian;

import java.util.List;
import java.util.Map;

public interface GuardianService extends BaseService<Guardian> {
    List<Guardian> selectByInfo(Map<String,Object> map);

    List<Guardian> selectByInfo(Guardian guardian);
}
