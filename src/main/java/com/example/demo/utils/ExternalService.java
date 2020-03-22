package com.example.demo.utils;


import java.util.List;

public interface ExternalService<T> {


    /**
     * 截取对应的数据
     *
     * @param offset 开始时间
     * @param limit  结束时间
     * @return the
     */
    List<T> fetch(int offset, int limit);
}
