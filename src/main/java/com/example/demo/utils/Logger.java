package com.example.demo.utils;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <同一类型的只能创建一个对象，不同类型的可以创建多个对象。这里的“类型”如何理解>
 * 同一个logger name获取到的对象实例是相同的，不同的logger name 获取到的对象的实例会不同的.
 *
 * @author fangyang
 * @create 2020-03-19
 * @since 1.0.0
 */
public class Logger {

    private static final ConcurrentHashMap<String, Logger> instances = new ConcurrentHashMap<>();

    private Logger() {
    }

    private static Logger getInstance(String loggerName) {
        instances.putIfAbsent(loggerName, new Logger());
        return instances.get(loggerName);
    }

    public void log() {
        //...
    }

    public static void main(String[] args) {
        //l1==l2, l1!=l3
        Logger l1 = Logger.getInstance("User.class");
        Logger l2 = Logger.getInstance("User.class");
        Logger l3 = Logger.getInstance("Order.class");

        new ArrayList<>()
    }

}


