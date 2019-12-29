package com.blue.thrift.java.thread.pool.threadGroup;

/**
 * Created by zs on 2017/5/30.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        ThreadGroup tg = new ThreadGroup("My Group");

        MyThread thrd = new MyThread(tg, "MyThread #1");
        MyThread thrd2 = new MyThread(tg, "MyThread #2");
        MyThread thrd3 = new MyThread(tg, "MyThread #3");

        thrd.start();
        thrd2.start();
        thrd3.start();

        Thread.sleep(1000);

        System.out.println(tg.activeCount() + " threads in thread group.");

        Thread thrds[] = new Thread[tg.activeCount()];
        tg.enumerate(thrds);//复制该线程组及其子组中的所有活动线程到指定的数组
        for (Thread t : thrds) {
            System.out.println("live:"+t.getName());
        }

        thrd.myStop();
        Thread.sleep(1000);

        System.out.println(tg.activeCount() + " threads in tg.");
        tg.interrupt();
    }
}

