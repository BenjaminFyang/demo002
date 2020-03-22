package com.example.demo.utils;

import java.util.stream.Stream;

/**
 * <>
 *
 * @author fangyang
 * @create 2020-03-20
 * @since 1.0.0
 */
public class Producer1 {

    private Stream<String> buildStream() {
        return Stream.of("a", "b", "c");
    }

    private String expensiveStringDoubler(String input) {
        return input + input;
    }

    public Stream<String> stream() {
        return buildStream().map(this::expensiveStringDoubler);
    }
}
