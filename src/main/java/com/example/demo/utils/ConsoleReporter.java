package com.example.demo.utils;

import com.example.demo.service.MetricsStorage;
import com.example.demo.service.StatViewer;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <相当于一个上帝类（God Class），定时根据给定的时间区间，从数据库中取出数据，借助 Aggregator 类完成统计工作，
 * 并将统计结果输出到相应的终端，比如命令行、邮件。>
 * 上帝类只负责组装类和串联执行的流程
 *
 * @author fangyang
 * @create 2020-03-05
 * @since 1.0.0
 */

@Slf4j
public class ConsoleReporter extends ScheduledReporter {

    private ScheduledExecutorService executor;

    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        super(metricsStorage, aggregator, viewer);
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }


    /**
     * 第4个代码逻辑：定时触发第1、2、3代码逻辑的执行；
     *
     * @param periodInSeconds   两次开始执行最小间隔时间
     * @param durationInSeconds 筛选指定的执行的时间
     */
    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executor.scheduleAtFixedRate(() -> {

            log.info("开始测试......");
            // 第1个代码逻辑：根据给定的时间区间，从数据库中拉取数据；
            long durationInMillis = durationInSeconds * 1000;
            long endTimeInMillis = System.currentTimeMillis();
            long startTimeInMillis = endTimeInMillis - durationInMillis;

            doStatAndReport(startTimeInMillis, endTimeInMillis);

//            Map<String, List<RequestInfo>> requestInfos =
//                    metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
//
//            Map<String, RequestStat> requestStats = null;
//            if (null != requestInfos) {
//                requestStats = aggregator.aggregate(requestInfos, durationInMillis);
//            }
//
//            viewer.output(requestStats, startTimeInMillis, endTimeInMillis);


            //  Map<String, RequestStat> stats = new HashMap<>();
//            if (null != requestInfos) {
//                for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
//                    String apiName = entry.getKey();
//                    List<RequestInfo> requestInfosPerApi = entry.getValue();
//
//                    // 第2个代码逻辑：根据原始数据，计算得到统计数据
//                    Aggregator.aggregate(requestInfosPerApi, durationInMillis);
//                    stats.put(apiName, requestStat);
//                }
//
//            }


            // 第3个代码逻辑：将统计数据显示到终端（命令行或邮件）；
            //  System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMillis + "]");
            // Gson gson = new Gson();
            // System.out.println(gson.toJson(stats));
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }


    public static void main(String[] args) {

        //使用Executors工具快速构建对象
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        System.out.println("3秒后开始执行计划线程池服务..." + new Date());


        //每间隔4秒执行一次任务
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            System.out.println("22323");

            System.out.println("222");
        }, 3, 4, TimeUnit.SECONDS);


    }

}

