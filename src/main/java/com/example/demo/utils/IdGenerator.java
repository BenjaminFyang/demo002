package com.example.demo.utils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * <定时的Id的生成>
 *
 * @author fangyang
 * @create 2020-03-18
 * @since 1.0.0
 */
public class IdGenerator {

    private AtomicLong id = new AtomicLong(0);

    private IdGenerator() {
    }

    /**
     * 通过静态内部类来处理.
     */
    private static class SingletonHolder {
        private static final IdGenerator instance = new IdGenerator();
    }

    public static IdGenerator getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }
}

// IdGenerator使用举例
// 懒汉模式、在类加载的时候。就已经初始化好了
