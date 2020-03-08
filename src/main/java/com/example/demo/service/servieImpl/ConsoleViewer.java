package com.example.demo.service.servieImpl;

import com.example.demo.service.StatViewer;
import com.google.gson.Gson;

import java.util.Map;

/**
 * <>
 *
 * @author fangyang
 * @create 2020-03-06
 * @since 1.0.0
 */
public class ConsoleViewer implements StatViewer {


    @Override
    public void output(Map requestStats, long startTimeInMillis, long endTimeInMills) {

        System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMills + "]");
        Gson gson = new Gson();
        System.out.println(gson.toJson(requestStats));
    }
}
