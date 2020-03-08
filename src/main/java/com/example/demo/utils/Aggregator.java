package com.example.demo.utils;

import com.example.demo.model.RequestInfo;
import com.example.demo.model.RequestStat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 原始步骤中的第二步 根据原始数据，计算得到统计数据；
 * <是一个工具类，负责各种统计数据的计算，
 * 比如响应时间的最大值、最小值、平均值、百分位值、接口访问次数、tps>
 *
 * @author fangyang
 * @create 2020-03-05
 * @since 1.0.0
 */

public class Aggregator {


    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos, long durationInMillis) {
        Map<String, RequestStat> requestStats = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> requestInfosPerApi = entry.getValue();
            RequestStat requestStat = doAggregate(requestInfosPerApi, durationInMillis);
            requestStats.put(apiName, requestStat);
        }
        return requestStats;
    }

    private RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        List<Double> respTimes = new ArrayList<>();
        for (RequestInfo requestInfo : requestInfos) {
            double respTime = requestInfo.getResponseTime();
            respTimes.add(respTime);
        }

        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(max(respTimes));
        requestStat.setMinResponseTime(min(respTimes));
        requestStat.setAvgResponseTime(avg(respTimes));
        requestStat.setP999ResponseTime(percentile999(respTimes));
        requestStat.setP99ResponseTime(percentile99(respTimes));
        requestStat.setCount(respTimes.size());
        requestStat.setTps((long) tps(respTimes.size(), durationInMillis / 1000));
        return requestStat;
    }

    // 以下的函数的代码实现均省略...
    private double max(List<Double> dataset) {
        return 0;
    }

    private double min(List<Double> dataset) {
        return 0;
    }

    private double avg(List<Double> dataset) {
        return 0;
    }

    private double tps(int count, double duration) {
        return 0;
    }

    private double percentile999(List<Double> dataset) {
        return 0;
    }

    private double percentile99(List<Double> dataset) {
        return 0;
    }

    private double percentile(List<Double> dataset, double ratio) {
        return 0;
    }
}


//    public static RequestStat aggregate(List<RequestInfo> requestInfos, long durationInMillis) {
//
//        double maxRespTime = Double.MIN_VALUE;
//        double minRespTime = Double.MAX_VALUE;
//        double avgRespTime = -1;
//        double p999RespTime = -1;
//        double p99RespTime = -1;
//        double sumRespTime = 0;
//        long count = 0;
//
//        for (RequestInfo requestInfo : requestInfos) {
//            ++count;
//            double respTime = requestInfo.getResponseTime();
//            if (maxRespTime < respTime) {
//                maxRespTime = respTime;
//            }
//            if (minRespTime > respTime) {
//                minRespTime = respTime;
//            }
//            sumRespTime += respTime;
//        }
//
//        if (count != 0) {
//            avgRespTime = sumRespTime / count;
//        }
//        long tps = (count / durationInMillis * 1000);
//
//        requestInfos.sort((o1, o2) -> {
//            double diff = o1.getResponseTime() - o2.getResponseTime();
//            return Double.compare(diff, 0.0);
//        });
//
//        if (count != 0) {
//            int idx999 = (int) (count * 0.999);
//            int idx99 = (int) (count * 0.99);
//            p999RespTime = requestInfos.get(idx999).getResponseTime();
//            p99RespTime = requestInfos.get(idx99).getResponseTime();
//        }
//
//        return new RequestStat(maxRespTime, minRespTime, avgRespTime, p999RespTime, p99RespTime,
//                count, tps);
//    }

