//package com.example.demo.web;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.util.IdGenerator;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.Random;
//import java.util.UUID;
//
///**
// * <&#x6d4b;&#x8bd5;>
// *
// * @author fangyang
// * @create 2020-02-14
// * @since 1.0.0
// */
//
///**
// * 生成唯一的key
// */
//public class RandomIdGenerator implements IdGenerator {
//    private static final Logger logger = LoggerFactory.getLogger(RandomIdGenerator.class);
//
//    @Override
//    public String generate() throws IdGenerationFailureException {
//        String substrOfHostName = null;
//        try {
//            substrOfHostName = getLastFiledOfHostName();
//        } catch (UnknownHostException e) {
//            throw new IdGenerationFailureException("...", e);
//        }
//        long currentTimeMillis = System.currentTimeMillis();
//        String randomString = generateRandomAlphameric(8);
//        String id = String.format("%s-%d-%s",
//                substrOfHostName, currentTimeMillis, randomString);
//        return id;
//    }
//
//    private String getLastFiledOfHostName() throws UnknownHostException {
//        String substrOfHostName = null;
//        String hostName = InetAddress.getLocalHost().getHostName();
//        if (hostName == null || hostName.isEmpty()) {
//            throw new UnknownHostException("...");
//        }
//        substrOfHostName = getLastSubstrSplittedByDot(hostName);
//        return substrOfHostName;
//    }
//
//    protected String getLastSubstrSplittedByDot(String hostName) {
//        if (hostName == null || hostName.isEmpty()) {
//            throw new IllegalArgumentException("...");
//        }
//
//        String[] tokens = hostName.split("\\.");
//        String substrOfHostName = tokens[tokens.length - 1];
//        return substrOfHostName;
//    }
//
//    protected String generateRandomAlphameric(int length) {
//        if (length <= 0) {
//            throw new IllegalArgumentException("...");
//        }
//
//        char[] randomChars = new char[length];
//        int count = 0;
//        Random random = new Random();
//        while (count < length) {
//            int maxAscii = 'z';
//            int randomAscii = random.nextInt(maxAscii);
//            boolean isDigit = randomAscii >= '0' && randomAscii <= '9';
//            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
//            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
//            if (isDigit || isUppercase || isLowercase) {
//                randomChars[count] = (char) (randomAscii);
//                ++count;
//            }
//        }
//        return new String(randomChars);
//    }
//
//    @Override
//    public UUID generateId() {
//        return null;
//    }
//}