//package com.example.demo.utils;
//
//import org.apache.catalina.User;
//import org.springframework.cache.CacheManager;
//
///**
// * <实例1>
// *
// * @author fangyang
// * @create 2020-03-18
// * @since 1.0.0
// */
//public class demo1 {
//
//    private UserRepo userRepo;
//
//    // 通过构造哈函数或IOC容器依赖注入
//    public boolean validateCachedUser(long userId) {
//        User cachedUser = CacheManager.getInstance().getUser(userId);
//        User actualUser = userRepo.getUser(userId); // 省略核心逻辑：对比cachedUser和actualUser... }
//
//        // 线程逻辑处理
//
//    }
//}
