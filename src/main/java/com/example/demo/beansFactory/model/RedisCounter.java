package com.example.demo.beansFactory.model;

import lombok.Data;

/**
 * <>
 *
 * @author fangyang
 * @create 2020-03-29
 * @since 1.0.0
 */
@Data
public class RedisCounter {
    private String ipAddress;
    private int port;

    public RedisCounter(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    @Override
    public String toString() {
        return "RedisCounter{" +
                "ipAddress='" + ipAddress + '\'' +
                ", port=" + port +
                '}';
    }
}
