package com.blue.thrift.thread.pool;

import java.lang.reflect.Proxy;
import java.util.HashMap;

/**
 * Created by zhouzhishuai on 2017/5/23.
 */
public class Teee {

    public static void main(String[] args) throws Exception {

        Object lock = new Object();
//
        Thread t = new Thread(new Run_1(lock));
        t.setName("Test-Thread——1");
        t.start();
//        t.stop();
//
////        Thread.sleep(1000);
//
//        Thread t2 = new Thread(new Run_2(lock));
//        t2.setName("Test-Thread-2");
//        t2.start();
//        Thread.sleep(1000);
//        synchronized (lock) {
////            lock.notify();
//            lock.notifyAll();
//        }

        int it = 1<<31;
        System.out.print(it + ":"+Integer.MIN_VALUE+","+Integer.MAX_VALUE);

    }

}

class Run_1 implements Runnable {
    private static Object ob;

    Run_1(Object o) {
        this.ob = o;
    }

    @Override
    public void run() {
        synchronized (ob) {
            try {
//                ob.wait();
//                ob.wait(1000000);
//                Thread.sleep(1000000);
                System.out.print("1111111111111");
                while (true){

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}


class Run_2 implements Runnable {
    private static Object ob;

    Run_2(Object o) {
        this.ob = o;
    }

    @Override
    public void run() {
        synchronized (ob) {
            try {
                ob.wait();
//                ob.wait(1000000);
//                Thread.sleep(1000000);
                System.out.print("2222222222");

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}