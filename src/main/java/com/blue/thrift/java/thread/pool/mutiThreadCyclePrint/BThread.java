package com.blue.thrift.java.thread.pool.mutiThreadCyclePrint;

/**
 * Created by zs on 2017/5/22.
 */
public class BThread implements Runnable {
    public static boolean isStop = false;
    public static boolean isRunning = false;
    private Object b;
    private Object c;

    BThread(Object self, Object next) {
        this.b = self;
        this.c = next;
    }

    @Override
    public void run() {
        while (isStop) {
            if (!CThread.isRunning) {
                try {
                    synchronized (c) {
                        isRunning = true;
                        System.out.print("b,");
                        c.notify();
                    }
                    synchronized (b) {
                        isRunning = false;
                        b.wait();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
