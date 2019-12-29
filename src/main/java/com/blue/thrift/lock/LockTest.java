package com.blue.thrift.lock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by zs on 2019/5/25.
 */
public class LockTest {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = reentrantReadWriteLock.readLock();
    private static Lock writeLock = reentrantReadWriteLock.writeLock();
    private static int value;

    public static Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);// 模拟读操作
            System.out.println("读操作:" + value);
            return value;
        } finally {
            lock.unlock();
        }
    }

    public static void handleWrite(Lock lock, int index)
            throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);// 模拟写操作
            System.out.println("写操作:" + value);
            value = index;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        TestReadThread testReadThread = new TestReadThread();
        TestWriteThread testWriteThread = new TestWriteThread();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 18; i++) {
            new Thread(testReadThread).start();
        }
        for (int i = 18; i < 20; i++) {
            new Thread(testWriteThread).start();
        }
        System.out.println(System.currentTimeMillis() - start + " ms");
//        Thread.sleep(100);
    }

    private static class TestReadThread extends Thread {
        @Override
        public void run() {
            try {
                LockTest.handleRead(lock);
//                LockTest.handleRead(readLock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class TestWriteThread extends Thread {
        @Override
        public void run() {
            try {
                LockTest.handleWrite(lock, new Random().nextInt(100));
//                LockTest.handleWrite(writeLock, new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
