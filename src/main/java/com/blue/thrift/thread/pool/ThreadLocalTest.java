package com.blue.thrift.thread.pool;

/**
 * Created by zhouzhishuai on 2017/6/8.
 */
public class ThreadLocalTest {


    static ThreadLocal<String> ss = new ThreadLocal<String>();

    public static void main(String[] args){

        ss.set("ss");



    }


}
