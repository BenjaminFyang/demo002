package com.example.demo.controller;

import com.example.demo.model.RequestInfo;
import com.example.demo.service.MetricsStorage;
import org.springframework.util.StringUtils;

/**
 * <MetricsCollector 负责采集和存储数据，职责相对来说还算比较单一。
 * 它基于接口而非实现编程，通过依赖注入的方式来传递 MetricsStorage 对象，
 * 可以在不需要修改代码的情况下，灵活地替换不同的存储方式，满足开闭原则。>
 *
 * @author fangyang
 * @create 2020-03-08
 * @since 1.0.0
 */
public class MetricsCollector {

    private MetricsStorage metricsStorage;

    // 进行依赖注入
    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }


    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isEmpty(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }

}
