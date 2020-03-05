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
public interface MetricsStorage {

    void saveRequestInfo(RequestInfo requestInfo);

    List getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}
