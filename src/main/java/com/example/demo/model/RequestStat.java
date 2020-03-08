package com.example.demo.model;

import lombok.Data;

/**
 * <>
 *
 * @author fangyang
 * @create 2020-03-05
 * @since 1.0.0
 */

@Data
public class RequestStat {

    /**
     * 接口的最大的响应的时间
     */
    private double maxResponseTime;

    /**
     * 接口最小的响应的时间
     */
    private double minResponseTime;

    /**
     * 接口的平均响应时间
     */
    private double avgResponseTime;

    /**
     * 接口的第999次的响应的时间.
     */
    private double p999ResponseTime;

    /**
     * 接口99次响应的时间
     */
    private double p99ResponseTime;

    /**
     * 请求的次数
     */
    private long count;
    private long tps;


    public RequestStat() {
    }

    public RequestStat(double maxResponseTime, double minResponseTime, double avgResponseTime,
                       double p999ResponseTime, double p99ResponseTime, long count, long tps) {
        this.maxResponseTime = maxResponseTime;
        this.minResponseTime = minResponseTime;
        this.avgResponseTime = avgResponseTime;
        this.p999ResponseTime = p999ResponseTime;
        this.p99ResponseTime = p99ResponseTime;
        this.count = count;
        this.tps = tps;
    }


    @Override
    public String toString() {
        return "RequestStat{" +
                "maxResponseTime=" + maxResponseTime +
                ", minResponseTime=" + minResponseTime +
                ", avgResponseTime=" + avgResponseTime +
                ", p999ResponseTime=" + p999ResponseTime +
                ", p99ResponseTime=" + p99ResponseTime +
                ", count=" + count +
                ", tps=" + tps +
                '}';
    }
}
