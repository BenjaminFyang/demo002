//package com.example.demo.demo;
//
//import java.util.HashMap;
//
///**
// * <>
// *
// * @author fangyang
// * @create 2020-03-29
// * @since 1.0.0
// */
//public class demo44 {
//
//
//    private static final Map<String, RuleConfigParser> cachedParsers = new HashMap<>();
//
//    static {
//        cachedParsers.put("json", new JsonRuleConfigParser());
//        cachedParsers.put("xml", new XmlRuleConfigParser());
//        cachedParsers.put("yaml", new YamlRuleConfigParser());
//        cachedParsers.put("properties", new PropertiesRuleConfigParser());
//    }
//
//    public static IRuleConfigParser createParser(String configFormat) {
//        if (configFormat == null || configFormat.isEmpty()) {
//            return null;//返回null还是IllegalArgumentException全凭你自己说了算
//        }
//        IRuleConfigParser parser = cachedParsers.get(configFormat.toLowerCase());
//        return parser;
//    }
//
//
//}
