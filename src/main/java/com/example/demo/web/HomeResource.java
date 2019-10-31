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


        // 1.我们的数据库的设计的模式存在的形式


        return "hello World";
    }
}
