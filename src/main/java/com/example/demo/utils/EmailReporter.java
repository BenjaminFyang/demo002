package com.example.demo.utils;

import com.example.demo.service.MetricsStorage;
import com.example.demo.service.StatViewer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * <对应的邮件的发送>
 *
 * @author fangyang
 * @create 2020-03-06
 * @since 1.0.0
 */

public class EmailReporter extends ScheduledReporter {
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatViewer viewer) {
        super(metricsStorage, aggregator, viewer);
    }

    public void startDailyReport() {

        Date firstTime = trimTimeFieldsToZeroOfNextDay();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                doStatAndReport(startTimeInMillis, endTimeInMillis);
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }


    /**
     * 获取当前时间的下一天的 0 点时间
     * 设置成protected而非private是为了方便写单元测试
     *
     * @return the date
     */
    protected Date trimTimeFieldsToZeroOfNextDay() {

        // 这里可以获取当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }


    public static void main(String[] args) {
        System.out.println("我们的测试的需求的方式");
    }
}