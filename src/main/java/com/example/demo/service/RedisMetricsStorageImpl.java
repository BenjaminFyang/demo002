package com.example.demo.service;

import com.example.demo.model.RequestInfo;

import java.util.List;
import java.util.Map;

/**
 * <>
 *
 * @author fangyang
 * @create 2020-03-05
 * @since 1.0.0
 */
public class RedisMetricsStorageImpl implements MetricsStorage {


    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {

    }

    @Override
    public List getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis) {
        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis) {
        return null;
    }
}
