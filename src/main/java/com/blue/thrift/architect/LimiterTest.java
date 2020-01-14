package com.blue.thrift.architect;

import com.google.common.util.concurrent.RateLimiter;

import java.util.LinkedHashMap;

/**
 * Created by zhishuai.zhou on 2020/1/2.
 */
public class LimiterTest {


    public static void main(String[] ss) {


        RateLimiter limiter = RateLimiter.create(5);

        ClassLoader classLoader = limiter.getClass().getClassLoader();

//        ClassLoader currentThreadClassLoader = Thread.currentThread().getClassLoader();

        LinkedHashMap linkedHashMap = new LinkedHashMap();


//        RateLimiter.class.newInstance();

    }


}
