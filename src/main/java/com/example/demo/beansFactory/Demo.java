package com.example.demo.beansFactory;


import com.example.demo.beansFactory.file.ApplicationContext;
import com.example.demo.beansFactory.file.ClassPathXmlApplicationContext;
import com.example.demo.beansFactory.model.RateLimiter;

/**
 * <>
 *
 * @author fangyang
 * @create 2020-03-29
 * @since 1.0.0
 */

public class Demo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        RateLimiter rateLimiter = (RateLimiter) applicationContext.getBean("rateLimiter");
        rateLimiter.test();
        //...
    }


}
