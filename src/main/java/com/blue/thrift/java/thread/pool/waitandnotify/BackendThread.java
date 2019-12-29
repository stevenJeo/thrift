package com.blue.thrift.java.thread.pool.waitandnotify;

/**
 * Created by zhouzhishuai on 2017/5/19.
 */
public class BackendThread implements Runnable {

    //    private ObjectWait =
    Object ob = ObjectWait.getInstanceObject().getObject("frontend");

    @Override
    public void run() {
        try {
            Thread.sleep(1000);//线程先暂停1s,保证FrontendThread先启动

            synchronized (ob) {

                System.out.print("获取ObjectWait对象锁, currentTimeMillis=" + System.currentTimeMillis() + "\n");
                ob.notify();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
