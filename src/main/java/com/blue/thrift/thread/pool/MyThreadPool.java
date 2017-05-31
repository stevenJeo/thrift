package com.blue.thrift.thread.pool;

import java.util.concurrent.*;

/**
 * Created by zhouzhishuai on 2017/5/18.
 */
public class MyThreadPool {


    public static void main(String[] args) {
        //获取当前设备CPU的个数
        int cpuNum = Runtime.getRuntime().availableProcessors();
        System.out.print("cpuNum=" + cpuNum);

        //放入线程池的线程，如果执行完了，该线程未达到被清理标准，可能会一直驻留在池内
        //线程池的类型
        ExecutorService s1 = Executors.newFixedThreadPool(4);//使用LinkedBlockingQueue(一个基于链表结构的阻塞队列), 一些很稳定很固定的正规并发线程，多用于服务器。
        ExecutorService s4 = Executors.newSingleThreadExecutor();
        ExecutorService s2 = Executors.newCachedThreadPool();//SynchronousQueue同步队列，效率较高，
        ExecutorService s3 = Executors.newScheduledThreadPool(3);

        s1.execute(new Thread());//执行一个线程
        s1.submit(new Thread());
        Semaphore sem = new Semaphore(300);
        sem.tryAcquire();


        //自定义线程池
        ThreadPoolExecutor customPool = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10));
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy());

        customPool.setThreadFactory(Executors.defaultThreadFactory());
        customPool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());

        //提交任务
//        customPool.execute();
//        customPool.submit();


    }

}
