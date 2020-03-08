package com.example.demo.model;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <>
 *
 * @author fangyang
 * @create 2020-03-08
 * @since 1.0.0
 */

public class Metrics {

    // Map的key是接口名称，value对应接口请求的响应时间或时间戳；
    private Map<String, List<Double>> responseTimes = new HashMap<>();
    private Map<String, List<Double>> timestamps = new HashMap<>();
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    /**
     * 记录接口的响应的时间
     *
     * @param apiName      对应的接口的名字
     * @param responseTime 对应的接口的响应的时间
     */
    public void recordResponseTime(String apiName, double responseTime) {
        responseTimes.putIfAbsent(apiName, new ArrayList<>());
        responseTimes.get(apiName).add(responseTime);
    }

    /**
     * 记录接口的访问的时间
     *
     * @param apiName   接口的名字
     * @param timestamp 对应接口的请求的时间
     */
    public void recordTimestamp(String apiName, double timestamp) {
        timestamps.putIfAbsent(apiName, new ArrayList<>());
        timestamps.get(apiName).add(timestamp);
    }


    /**
     * 以指定的频率统计数据并输出结果
     *
     * @param period 响应的时间
     * @param unit   时间的单位
     */
    public void startRepeatedReport(long period, TimeUnit unit) {

        executor.scheduleAtFixedRate(() -> {
            Gson gson = new Gson();
            Map<String, Map<String, Double>> stats = new HashMap<>();
            for (Map.Entry<String, List<Double>> entry : responseTimes.entrySet()) {
                String apiName = entry.getKey();
                List<Double> apiRespTimes = entry.getValue();
                stats.putIfAbsent(apiName, new HashMap<>());
                stats.get(apiName).put("max", max(apiRespTimes));
                stats.get(apiName).put("avg", avg(apiRespTimes));
            }

            for (Map.Entry<String, List<Double>> entry : timestamps.entrySet()) {
                String apiName = entry.getKey();
                List<Double> apiTimestamps = entry.getValue();
                stats.putIfAbsent(apiName, new HashMap<>());
                stats.get(apiName).put("count", (double) apiTimestamps.size());
            }
            System.out.println(gson.toJson(stats));
        }, 0, period, unit);
    }

    /**
     * 找到接口响应时间最长的
     *
     * @param dataset 响应时间的集合
     * @return the double
     */
    private double max(List dataset) {
        return 0L;
    }

    /**
     * 找到响应时间最短的
     *
     * @param dataset 响应时间的集合
     * @return the double
     */
    private double avg(List dataset) {
        return 0L;
    }

}


