package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.SampleDAO;
import com.example.vo.SampleVO;

@Service
public class SampleServiceImpl implements SampleService {
    
    @Autowired
    private SampleDAO sampleDAO;
    
    @Override
    public void insertSample(SampleVO sample) {
        sampleDAO.insertSample(sample);
    }
    
    @Override
    public void updateSample(SampleVO sample) {
        sampleDAO.updateSample(sample);
    }
    
    @Override
    public void deleteSample(int idx) {
        sampleDAO.deleteSample(idx);
    }
    
    @Override
    public List<SampleVO> selectSampleList() {
        return sampleDAO.selectSampleList();
    }
    
    @Override
    public SampleVO selectSample(int idx) {
        return sampleDAO.selectSample(idx);
    }
}
