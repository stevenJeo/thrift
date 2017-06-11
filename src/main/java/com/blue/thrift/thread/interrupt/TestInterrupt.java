package com.blue.thrift.thread.interrupt;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhouzhishuai on 2017/6/9.
 */
public class TestInterrupt {

    public static void main(String[] args) throws Exception {

        Runnable r =new T_interrupt();

        Thread t = new Thread(r);
        t.setName("1");
        t.start();
//        Thread.currentThread().wait(1000);
//        t.interrupt();

        Thread t2 = new Thread(r);
        t2.setName("2");
        t2.start();

        for (int i=0;i<1000000;i++){

        }
        t2.interrupt();


//        t.join();
    }

}

class T_interrupt implements Runnable {

    private static Object o = new Object();

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.print(Thread.currentThread().getName() + " await lock" + "\n");
                synchronized (o) {

                    System.out.print(Thread.currentThread().getName() + " get lock" + "\n");
                    Thread.sleep(10000000);
                    Thread.currentThread().interrupt();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }

        }


    }

}
