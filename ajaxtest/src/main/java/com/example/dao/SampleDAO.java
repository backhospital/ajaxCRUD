package com.example.dao;

import java.util.List;

import com.example.vo.SampleVO;

public interface SampleDAO {
    public void insertSample(SampleVO sample);
    public void updateSample(SampleVO sample);
    public void deleteSample(int idx);
    public List<SampleVO> selectSampleList();
    public SampleVO selectSample(int idx);
}

