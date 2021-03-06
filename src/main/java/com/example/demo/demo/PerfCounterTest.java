package com.example.demo.demo;

import com.example.demo.controller.MetricsCollector;
import com.example.demo.model.RequestInfo;
import com.example.demo.service.MetricsStorage;
import com.example.demo.service.servieImpl.ConsoleViewer;
import com.example.demo.service.servieImpl.EmailViewer;
import com.example.demo.service.servieImpl.RedisMetricsStorageImpl;
import com.example.demo.utils.Aggregator;
import com.example.demo.utils.ConsoleReporter;
import com.example.demo.utils.EmailReporter;

/**
 * <>
 *
 * @author fangyang
 * @create 2020-03-08
 * @since 1.0.0
 */

public class PerfCounterTest {


    public static void main(String[] args) {
        MetricsStorage storage = new RedisMetricsStorageImpl();
        Aggregator aggregator = new Aggregator();

        // 定时触发统计并将结果显示到终端
        ConsoleViewer consoleViewer = new ConsoleViewer();
        ConsoleReporter consoleReporter = new ConsoleReporter(storage, aggregator, consoleViewer);
        consoleReporter.startRepeatedReport(60, 3);

        // 定时触发统计并将结果输出到邮件
        EmailViewer emailViewer = new EmailViewer();
        emailViewer.addToAddress("wangzheng@xzg.com");
        EmailReporter emailReporter = new EmailReporter(storage, aggregator, emailViewer);
        emailReporter.startDailyReport();

        // 收集接口访问数据
        MetricsCollector collector = new MetricsCollector(storage);
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("register", 323, 12334));
        collector.recordRequest(new RequestInfo("login", 23, 12434));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}