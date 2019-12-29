package com.blue.thrift.java.thread.pool.mutiThreadCyclePrint;

/**
 * Created by zs on 2017/5/22.
 */
public class AThread implements Runnable {

    public static boolean isStop = false;
    public static boolean isRunning = false;
    private Object a;
    private Object b;

    AThread(Object self, Object next) {
        this.a = self;
        this.b = next;
    }

    @Override
    public void run() {
        while (isStop) {
            if(!BThread.isRunning){
                try {
                    synchronized (b) {//启动b线程
                        isRunning = true;
                        System.out.print("a,");
                        b.notify();
                    }
                    synchronized (a) {//暂停a线程
                        isRunning = false;
                        a.wait();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
