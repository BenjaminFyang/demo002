package com.example.demo.utils;

import com.example.demo.model.RequestInfo;
import com.example.demo.model.RequestStat;
import com.example.demo.service.MetricsStorage;
import com.example.demo.service.StatViewer;

import java.util.*;

/**
 * <对应的邮件的发送>
 *
 * @author fangyang
 * @create 2020-03-06
 * @since 1.0.0
 */
public class EmailReporter {

    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    private MetricsStorage metricsStorage;
    private Aggregator aggregator;
    private StatViewer viewer;


    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        this.metricsStorage = metricsStorage;
        this.viewer = viewer;
        this.aggregator = aggregator;
    }


    // 指定的时间、每天凌晨开始执行 开始邮件的推送、或者钉钉的报警
    public void startDailyReport() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date firstTime = calendar.getTime();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                Map<String, List<RequestInfo>> requestInfos = metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);

                Map<String, RequestStat> stats = aggregator.aggregate(requestInfos, durationInMillis);

                viewer.output(stats, startTimeInMillis, endTimeInMillis);

//                Map<String, RequestStat> stats = new HashMap<>();
//                for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
//                    String apiName = entry.getKey();
//                    List requestInfosPerApi = entry.getValue();
//                    aggregator.aggregate(requestInfos, durationInMillis);
//                    stats.put(apiName, requestStat);
//
//
//                    //  stats.put(apiName, requestStat);
//                }
//
//                System.out.println(stats);
//                // TODO: 格式化为html格式，并且发送邮件
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }
}