//package com.example.demo.utils;
//
//
//import java.util.List;
//import java.util.stream.Stream;
//
///**
// * <>
// *
// * @author fangyang
// * @create 2020-03-20
// * @since 1.0.0
// */
//public class Service<T> {
//
//
//    private final ExternalService<T> externalService = null;
//
//    public Stream<T> stream(int size, int batchSize) {
//        Cursor cursor = new Cursor();
//
//
//        return Stream
//                .generate(() -> next(cursor, size, batchSize))
//                .takeWhile((List::isEmpty))
//                .flatMap(List::stream);
//    }
//
//    private List<T> next(Cursor cursor, int size, int batchSize) {
//        int fetchSize = Math.min(size - cursor.getOffset(), batchSize);
//        List<T> result = externalService.fetch(cursor.getOffset(), fetchSize);
//        cursor.inc(result.size());
//        return result;
//    }
//}
