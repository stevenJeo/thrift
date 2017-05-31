package com.blue.thrift.thread.pool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhouzhishuai on 2017/5/26.
 */
public class MyThread {

    public static void main(String[] args) throws Exception {

        Thread t = new Thread(new TTT());
        t.setName("wwwwwwwww");
        t.start();

//        t.join(8000);

        while (true){
//            System.out.print("while");
        }

//        System.out.print("main end");

    }


}


class TTT implements Runnable {
    private AtomicInteger ai = new AtomicInteger();

    @Override
    public void run() {
        ai.incrementAndGet();
        int i = 0;
        while (true) {
            if(i==1000){
                System.out.print("Thread.yield()");
                Thread.yield();break;
            }
//        while (true) {
//
//        }
        i++;

        }
    }
}
