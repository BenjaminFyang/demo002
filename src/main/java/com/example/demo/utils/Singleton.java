package com.example.demo.utils;

import lombok.Getter;

/**
 * <单例>
 *
 * @author fangyang
 * @create 2020-03-18
 * @since 1.0.0
 */
@Getter
public class Singleton {
    private static Singleton instance = null;
    private final int paramA;
    private final int paramB;

    private Singleton(int paramA, int paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    private static Singleton getInstance() {
        if (instance == null) {
            throw new RuntimeException("Run init() first.");
        }
        return instance;
    }

    private synchronized static Singleton init(int paramA, int paramB) {
        if (instance != null) {
            throw new RuntimeException("Singleton has been created!");
        }
        instance = new Singleton(paramA, paramB);
        return instance;
    }

    public static void main(String[] args) {
        Singleton.init(10, 50); // 先init，再使用
        Singleton singleton = Singleton.getInstance();
        int paramA = singleton.getParamA();
        System.out.println(paramA);

        System.out.println(singleton);
    }

}

