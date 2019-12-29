package com.blue.thrift.java.thread.pool.threadGroup;

/**
 * Created by zs on 2017/5/30.
 */
public class MyThread extends Thread {
    boolean stopped;

    MyThread(ThreadGroup tg, String name) {
        super(tg, name);
        stopped = false;

    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " starting.");
        try {
            for (int i = 1; i < 1000; i++) {
                System.out.print(".");
                Thread.sleep(250);
                synchronized (this) {
                    if (stopped)
                        break;
                }
            }
        } catch (Exception exc) {
            System.out.println(Thread.currentThread().getName() + " interrupted.");
        }
        System.out.println(Thread.currentThread().getName() + " exiting.");
    }

    synchronized void myStop() {
        stopped = true;

    }


}

