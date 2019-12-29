package com.blue.thrift.java.thread.pool.mutiThreadCyclePrint;

/**
 * Created by zhouzhishuai on 2017/5/22.
 */
public class CThread implements Runnable {
    public static boolean isStop = false;
    public static boolean isRunning = false;
    private Object c;
    private Object a;


    CThread(Object self, Object next) {
        this.c = self;
        this.a = next;
    }

    @Override
    public void run() {
        while (isStop) {
            if (!AThread.isRunning) {
                try {
                    synchronized (a) {
                        isRunning = true;
                        System.out.print("c" + "\n");
                        a.notify();
                    }
                    synchronized (c) {
                        isRunning = false;
                        c.wait();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
