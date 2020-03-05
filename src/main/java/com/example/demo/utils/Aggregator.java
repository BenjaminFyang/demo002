package com.example.demo.utils;

import com.example.demo.model.RequestInfo;
import com.example.demo.model.RequestStat;

import java.util.List;


/**
 * <是一个工具类，负责各种统计数据的计算，
 * 比如响应时间的最大值、最小值、平均值、百分位值、接口访问次数、tps>
 *
 * @author fangyang
 * @create 2020-03-05
 * @since 1.0.0
 */

public class Aggregator {

    public static RequestStat aggregate(List<RequestInfo> requestInfos, long durationInMillis) {

        double maxRespTime = Double.MIN_VALUE;
        double minRespTime = Double.MAX_VALUE;
        double avgRespTime = -1;
        double p999RespTime = -1;
        double p99RespTime = -1;
        double sumRespTime = 0;
        long count = 0;

        for (RequestInfo requestInfo : requestInfos) {
            ++count;
            double respTime = requestInfo.getResponseTime();
            if (maxRespTime < respTime) {
                maxRespTime = respTime;
            }
            if (minRespTime > respTime) {
                minRespTime = respTime;
            }
            sumRespTime += respTime;
        }

        if (count != 0) {
            avgRespTime = sumRespTime / count;
        }
        long tps = (count / durationInMillis * 1000);

        requestInfos.sort((o1, o2) -> {
            double diff = o1.getResponseTime() - o2.getResponseTime();
            return Double.compare(diff, 0.0);
        });

        if (count != 0) {
            int idx999 = (int) (count * 0.999);
            int idx99 = (int) (count * 0.99);
            p999RespTime = requestInfos.get(idx999).getResponseTime();
            p99RespTime = requestInfos.get(idx99).getResponseTime();
        }

        return new RequestStat(maxRespTime, minRespTime, avgRespTime, p999RespTime, p99RespTime,
                count, tps);
    }
}

