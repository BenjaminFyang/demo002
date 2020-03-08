package com.example.demo.service;

import com.example.demo.model.RequestStat;

import java.util.Map;

public interface StatViewer {

    void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills);
}
