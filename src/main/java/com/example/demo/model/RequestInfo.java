package com.example.demo.model;

import lombok.Data;

/**
 * <请求的详细的信息>
 *
 * @author fangyang
 * @create 2020-03-05
 * @since 1.0.0
 */

@Data
public class RequestInfo {

    /**
     * 对应的API接口的名字
     */
    private String apiName;

    private double responseTime;
    private long timestamp;

    public RequestInfo(String apiName, double responseTime, long timestamp) {
        this.apiName = apiName;
        this.responseTime = responseTime;
        this.timestamp = timestamp;
    }


    @Override
    public String toString() {
        return "RequestInfo{" +
                "apiName='" + apiName + '\'' +
                ", responseTime=" + responseTime +
                ", timestamp=" + timestamp +
                '}';
    }
}
