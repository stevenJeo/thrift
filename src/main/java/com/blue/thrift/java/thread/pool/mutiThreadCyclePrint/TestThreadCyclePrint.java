package com.blue.thrift.java.thread.pool.mutiThreadCyclePrint;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhouzhishuai on 2017/5/22.
 */
public class TestThreadCyclePrint {


    /**
     * 三个线程循环打印A、B、C
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        Thread ta = new Thread(new AThread(a, b));ta.setName("Thread-A");
        Thread tb = new Thread(new BThread(b, c));tb.setName("Thread-B");
        Thread tc = new Thread(new CThread(c, a));tc.setName("Thread-C");

        AThread.isStop = true;//停止线程用
        BThread.isStop = true;
        CThread.isStop = true;

        ta.start();
        Thread.sleep(1000);//保证ta线程先启动
        tb.start();
        tc.start();


        Lock ll = new ReentrantLock(true);
    }
}
