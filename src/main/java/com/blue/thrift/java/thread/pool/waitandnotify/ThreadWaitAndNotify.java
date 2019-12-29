package com.blue.thrift.java.thread.pool.waitandnotify;

import java.util.concurrent.*;

/**
 * Created by zs on 2017/5/19.
 */
public class ThreadWaitAndNotify {

    public static void main(String[] args) throws Exception{

        ThreadPoolExecutor pool2 = (ThreadPoolExecutor)Executors.newFixedThreadPool(1);

        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 2, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        Runnable f = new FrontendThread();
        Runnable b = new BackendThread();
//
        pool.execute(f);
        pool.execute(b);

//        Thread t1 = new Thread(f);
//        t1.setName("t1-");
//        Thread t2 = new Thread(b);
//        t2.setName("t2-");

//        t1.start();
//        t2.start();

    }
}




