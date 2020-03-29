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
public class RateLimiter {

    private RedisCounter redisCounter;

    public RateLimiter(RedisCounter redisCounter) {
        this.redisCounter = redisCounter;
    }

    public void test() {
        System.out.println("Hello World!");
    }


}
