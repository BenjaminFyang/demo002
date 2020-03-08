package com.example.demo.controller;

import com.example.demo.VO.UserVo;
import com.example.demo.model.Metrics;

import java.util.concurrent.TimeUnit;

/**
 * <应用场景：统计下面两个接口(注册和登录）的响应时间和访问次数>
 * <p>
 * 框架可以分成四种数据采集、储存、集合统计、显示
 *
 * @author fangyang
 * @create 2020-03-08
 * @since 1.0.0
 */

public class UserController {

    private Metrics metrics = new Metrics();

    public UserController() {
        metrics.startRepeatedReport(60, TimeUnit.SECONDS);
    }

    /**
     * 用户注册
     *
     * @param user 用户的注册信息
     */
    public void register(UserVo user) {
        long startTimestamp = System.currentTimeMillis();
        metrics.recordTimestamp("register", startTimestamp);
        //...
        long respTime = System.currentTimeMillis() - startTimestamp;
        metrics.recordResponseTime("register", respTime);
    }

    /**
     * 商家的登陆
     *
     * @param telephone 手机号码
     * @param password  对应密码
     * @return the UserVo
     */
    public UserVo login(String telephone, String password) {
        long startTimestamp = System.currentTimeMillis();
        metrics.recordTimestamp("login", startTimestamp);
        //...
        long respTime = System.currentTimeMillis() - startTimestamp;
        metrics.recordResponseTime("login", respTime);
        return new UserVo();
    }
}
