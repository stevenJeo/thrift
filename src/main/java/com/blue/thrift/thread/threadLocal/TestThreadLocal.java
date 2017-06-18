package com.blue.thrift.thread.threadLocal;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by zhouzhishuai on 2017/6/11.
 * <p/>
 * 1.线程中的变量如何保证各个线程对象中会不影响？
 * </>各线程中为使用的变量维护一个独立的变量副本（该变量用ThreadLocal修饰，）
 * 2.ThreadLocal的结构是怎么样的？
 * </>ThreadLocal其实内部用一个ThreadLocalMap存储每个线程变量的副本，Map中元素的key为线程对象，value为对应线程的变量副本；
 * 3.共享变量的线程安全问题，与synchronized的区别
 * </>同步锁机制是采用时间换空间，而ThreadLocal是采用变量副本以空间换时间。
 *
 * @see http://blog.csdn.net/lufeng20/article/details/24314381
 */
public class TestThreadLocal {

    //通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
//    private static ThreadLocal<Integer> localNum = new ThreadLocal<Integer>() {
//        @Override
//        protected Integer initialValue() {
//            return 0;
//        }
//    };
//
//    public int getNextNum() {
//        localNum.set(localNum.get() + 1);
//        return localNum.get();
//    }

    //变量非threadLocal，各线程之间会有干扰
    private static Integer localNum = 0;

    public int getNextNum() {
        localNum++;
        return localNum;
    }


    public static void main(String[] args) throws Exception {
        TestThreadLocal lco = new TestThreadLocal();
        TestThread t1 = new TestThread(lco);
        TestThread t2 = new TestThread(lco);
        TestThread t3 = new TestThread(lco);
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(30000);
        System.out.print("final." + TestThreadLocal.localNum + "\n");


    }

    //测试线程
    private static class TestThread extends Thread {
        private TestThreadLocal lc;

        public TestThread(TestThreadLocal lc) {
            this.lc = lc;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                //每个线程打出3个序列值
                System.out.print("thread[" + Thread.currentThread().getName() + "] --> sn[" + lc.getNextNum() + "] \n");
            }
        }
    }

}
