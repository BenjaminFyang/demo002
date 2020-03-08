//package com.example.demo.demo;
//
//import com.example.demo.controller.MetricsCollector;
//import com.example.demo.model.RequestInfo;
//import com.example.demo.service.MetricsStorage;
//import com.example.demo.service.servieImpl.RedisMetricsStorageImpl;
//import com.example.demo.utils.ConsoleReporter;
//import com.example.demo.utils.EmailReporter;
//
///**
// * <>
// *
// * @author fangyang
// * @create 2020-03-08
// * @since 1.0.0
// */
//
//public class Demo {
//    public static void main(String[] args) {
//
//        // 控制台的推送
//        MetricsStorage storage = new RedisMetricsStorageImpl();
//        ConsoleReporter consoleReporter = new ConsoleReporter(storage);
//
//        // 一分钟之前
//        consoleReporter.startRepeatedReport(2, 60);
//
//        // 开始邮件的推送定时任务
//        EmailReporter emailReporter = new EmailReporter(storage);
//        emailReporter.addToAddress("wangzheng@xzg.com");
//        emailReporter.startDailyReport();
//
//        MetricsCollector collector = new MetricsCollector(storage);
//        collector.recordRequest(new RequestInfo("register", 123, 10234));
//        collector.recordRequest(new RequestInfo("register", 223, 11234));
//        collector.recordRequest(new RequestInfo("register", 323, 12334));
//        collector.recordRequest(new RequestInfo("login", 23, 12434));
//        collector.recordRequest(new RequestInfo("login", 1223, 14234));
//
////        try {
////            Thread.sleep(100000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//    }
//
//
//}