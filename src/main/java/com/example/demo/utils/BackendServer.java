package com.example.demo.utils;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * <这个方法的对象、对象已经实例话三个对象
 * 多例的模式:一个类可以创建多个对象、但是个数有限制，比如下面的只能创建三个对象>
 *
 * @author fangyang
 * @create 2020-03-19
 * @since 1.0.0
 */
@Getter
public class BackendServer {

    /**
     * 服务器上面的编号.
     */
    private long serverNo;

    /**
     * 服务器上的地址.
     */
    private String serverAddress;

    private static final int SERVER_COUNT = 3;
    private static final Map<Long, BackendServer> serverInstances = new HashMap<>();

    static {
        serverInstances.put(1L, new BackendServer(1L, "192.134.22.138:8080"));
        serverInstances.put(2L, new BackendServer(2L, "192.134.22.139:8080"));
        serverInstances.put(3L, new BackendServer(3L, "192.134.22.140:8080"));
    }

    private BackendServer(long serverNo, String serverAddress) {
        this.serverNo = serverNo;
        this.serverAddress = serverAddress;
    }

    /**
     * 根据编号获取实例
     *
     * @param serverNo 服务器的编号
     * @return the BackendServer
     */
    public BackendServer getInstance(long serverNo) {
        return serverInstances.get(serverNo);
    }


    /**
     * 随机获取对应的实例
     *
     * @return the BackendServer
     */
    public BackendServer getRandomInstance() {
        Random r = new Random();
        int no = r.nextInt(SERVER_COUNT) + 1;
        return serverInstances.get(no);
    }
}