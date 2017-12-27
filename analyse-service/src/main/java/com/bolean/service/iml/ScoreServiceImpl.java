package com.bolean.service.iml;

import com.bolean.dao.ScoreMapper;
import com.bolean.entity.Score;
import com.bolean.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public List<Score> selectAll() {
        return scoreMapper.selectAll();
    }

    @Override
    public List<Score> select(Score score) {
        return scoreMapper.select(score);
    }

    @Override
    public Score selectByPrimaryKey(long id) {
        return scoreMapper.selectByPrimaryKey(id);
    }

    @Override
    public Score selectOne(Score score) {
        return scoreMapper.selectOne(score);
    }

    @Override
    public int insert(Score score) {
        return scoreMapper.insert(score);
    }

    @Override
    public int insertSelective(Score score) {
        return 0;
    }

    @Override
    public int insertList(List<Score> scores) {
        return scoreMapper.insertList(scores);
    }

    @Override
    public int updateByPrimaryKey(Score score) {
        return scoreMapper.updateByPrimaryKey(score);
    }

    @Override
    public int updateByPrimaryKeySelective(Score score) {
        return 0;
    }

    @Override
    public int selectCount(Score score) {
        return selectCount(score);
    }

}
