package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <提示>
 *
 * @author fangyang
 * @create 2019-10-26
 * @since 1.0.0
 */

@RestController
public class HomeResource {

    /**
     * 测试的第一行的代码
     *
     * @return the String
     */
    @GetMapping("/hello")
    public String hello() {
        return "hello World";
    }


    public static void main(String[] args) {
        System.out.println("测试方法");

        Object o = new Object();
        if (o != null) {
            System.out.println("数据库的数据不能为空");
        }


    }
}
