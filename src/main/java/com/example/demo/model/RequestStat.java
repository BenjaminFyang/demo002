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
    private double maxResponseTime;
    private double minResponseTime;
    private double avgResponseTime;
    private double p999ResponseTime;
    private double p99ResponseTime;
    private long count;
    private long tps;


    /**
     * 构造函数封装
     *
     * @param maxResponseTime
     * @param minResponseTime
     * @param avgResponseTime
     * @param p999ResponseTime
     * @param p99ResponseTime
     * @param count
     * @param tps
     */
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
