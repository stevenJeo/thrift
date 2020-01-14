package com.blue.thrift.java.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhishuai.zhou on 2020/1/4.
 */
public class CountDownLatchTest {


    public static void main(String[] ss) throws Exception {
        CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = new Thread() {

            @Override
            public void run() {
                try {
                    System.out.println("t1 run ...");
                    Thread.sleep(2000);

                    latch.countDown();

                    System.out.println("t1 run done..." + latch.getCount());
                } catch (Exception e) {
                    System.out.println("t1 run exception...");
                }
            }
        };

        Thread t2 = new Thread() {

            @Override
            public void run() {
                try {
                    System.out.println("t2 run ...");
                    Thread.sleep(10000);

                    latch.countDown();

                    System.out.println("t2 run done..." + latch.getCount());
                } catch (Exception e) {
                    System.out.println("t2 run exception...");
                }
            }
        };

        t1.start();
        t2.start();

        System.out.println("latch run ready..." + latch.getCount());
//        latch.await();
        latch.await(3, TimeUnit.SECONDS);

        System.out.println("latch run done..." + latch.getCount());


    }
}
