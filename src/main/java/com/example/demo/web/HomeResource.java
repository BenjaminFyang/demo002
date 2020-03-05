package com.example.demo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <提示>
 *
 * @author fangyang
 * @create 2019-10-26
 * @since 1.0.0
 */

@RestController
public class HomeResource {


    private static final Logger logger = LoggerFactory.getLogger(HomeResource.class);

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

        // 1.我们的数据库的设计模式方
        System.out.println("我们的数据的设计模式");
        System.out.println("fe");

        String substrOfHostName = null;
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            substrOfHostName = (String) getLastSubstrSplittedByDot(hostName);
        } catch (UnknownHostException e) {
            logger.warn("Failed to get the host name.", e);
        }
        System.out.println(substrOfHostName);
    }


    protected static String getLastSubstrSplittedByDot(String hostName) {
        String[] tokens = hostName.split("\\.");
        String substrOfHostName = tokens[tokens.length - 1];
        return substrOfHostName;
    }

}

