package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vo.SampleVO;

@Repository
public class SampleDAOImpl implements SampleDAO {
    
    @Autowired
    private SqlSession sqlSession;
    
    private static final String NAMESPACE = "com.example.mapper.testMapper";
    
    @Override
    public void insertSample(SampleVO sample) {
        sqlSession.insert(NAMESPACE + ".insertSample", sample);
    }
    
    @Override
    public void updateSample(SampleVO sample) {
        sqlSession.update(NAMESPACE + ".updateSample", sample);
    }
    
    @Override
    public void deleteSample(int idx) {
        sqlSession.delete(NAMESPACE + ".deleteSample", idx);
    }
    
    @Override
    public List<SampleVO> selectSampleList() {
        return sqlSession.selectList(NAMESPACE + ".selectSampleList");
    }
    
    @Override
    public SampleVO selectSample(int idx) {
        return sqlSession.selectOne(NAMESPACE + ".selectSample", idx);
    }
}


