package com.example.demo.service;

import com.example.demo.model.RequestInfo;

import java.util.List;
import java.util.Map;

/**
 * <使用接口这样做是为了今后灵活地扩展新的存储方法，比如用 HBase 来存储。>
 * 1、根据给定的时间区间，从数据库中拉取数据
 * 2、根据原始数据计算得到统计数据
 * 3、将统计数据显示到终端命令行或者邮件）
 * 4、定时触发三个以上的过程
 *
 * @author fangyang
 * @create 2020-03-05
 * @since 1.0.0
 */
public interface MetricsStorage {

    /**
     * 将接口的请求的基本的数据打印出来
     *
     * @param requestInfo 请求封装的对象H˙
     */
    void saveRequestInfo(RequestInfo requestInfo);

    /**
     * 得到某个时间段接口的请求的基本的信息
     *
     * @param apiName           接口的名字
     * @param startTimeInMillis 筛选的开始时间
     * @param endTimeInMillis   筛选的结束时间
     * @return the list
     */
    List getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

    /**
     * 得到时间段接口的请求的基本的信息
     *
     * @param startTimeInMillis 筛选的开始时间
     * @param endTimeInMillis   筛选的结束时间
     * @return the list
     */
    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}
