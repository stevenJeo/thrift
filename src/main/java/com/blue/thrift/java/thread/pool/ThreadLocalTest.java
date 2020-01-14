package com.blue.thrift.java.thread.pool;

/**
 * Created by zs on 2017/6/8.
 */
public class ThreadLocalTest {


    static ThreadLocal<String> ss = new ThreadLocal<String>();

    public static void main(String[] args) {

        ss.set("ss");

        System.out.println(ss.get());

    }


}
