package com.example.demo.utils;

import com.example.demo.model.RequestInfo;
import com.example.demo.model.RequestStat;
import com.example.demo.service.MetricsStorage;
import com.example.demo.service.StatViewer;

import java.util.List;
import java.util.Map;

/**
 * <定时播报的父类、将相同的逻辑代码抽离出去>
 *
 * @author fangyang
 * @create 2020-03-09
 * @since 1.0.0
 */
public abstract class ScheduledReporter {
    private MetricsStorage metricsStorage;
    private Aggregator aggregator;
    private StatViewer viewer;

    ScheduledReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.aggregator = aggregator;
        this.viewer = viewer;
    }

    void doStatAndReport(long startTimeInMillis, long endTimeInMillis) {
        long durationInMillis = endTimeInMillis - startTimeInMillis;
        Map<String, List<RequestInfo>> requestInfos =
                metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
        Map<String, RequestStat> requestStats = null;
        if (null != requestInfos) {
            requestStats = aggregator.aggregate(requestInfos, durationInMillis);
        }
        viewer.output(requestStats, startTimeInMillis, endTimeInMillis);
    }

}
