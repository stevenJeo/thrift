package com.blue.thrift.thread.pool.waitandnotify;

/**
 * Created by zhouzhishuai on 2017/5/19.
 */
public class FrontendThread implements Runnable {

    Object ob = ObjectWait.getInstanceObject().setKey("frontend");

    @Override
    public void run() {

        synchronized (ob) {
            try {
                System.out.print("frontend thread wait...5 * 1000, currentTimeMillis=" + System.currentTimeMillis() + "\n");
                ob.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.print("frontend thread run, currentTimeMillis=" + System.currentTimeMillis() + "\n");

    }
}