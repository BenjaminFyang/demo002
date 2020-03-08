package com.example.demo.service.servieImpl;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.RequestInfo;
import com.example.demo.service.MetricsStorage;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * <>
 *
 * @author fangyang
 * @create 2020-03-05
 * @since 1.0.0
 */
@Slf4j
public class RedisMetricsStorageImpl implements MetricsStorage {

    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {
        // 将原始数据信息储存起来 利用redis的缓存
        log.info("#RedisMetricsStorageImpl#saveRequestInfo开始存储请求的信息requestInfo={}", JSON.toJSON(requestInfo));

    }

    @Override
    public List getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis) {
        log.info("RedisMetricsStorageImpl#getRequestInfos得到商家的请求的时间apiName={},startTimeInMillis={},endTimeInMillis={}", apiName, startTimeInMillis, endTimeInMillis);

        return null;
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis) {
        log.info("#RedisMetricsStorageImpl#getRequestInfos得到指定的时间范围的时间请求startTimeInMillis={},endTimeInMillis={}", startTimeInMillis, endTimeInMillis);

        return null;


    }
}
