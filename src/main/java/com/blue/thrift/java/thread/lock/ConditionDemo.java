package com.blue.thrift.java.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhouzhishuai on 2017/6/5.
 */
public class ConditionDemo {
    volatile int key = 0;
    Lock l = new ReentrantLock();
    Condition c = l.newCondition();

    public static  void main(String[] args){
        ConditionDemo demo = new ConditionDemo();
        new Thread(demo.new A()).start();
        new Thread(demo.new B()).start();
        new Thread(demo.new C()).start();
    }

    class A implements Runnable{
        @Override
        public void run() {
            int i = 10;
            while(i > 0){
                l.lock();
                try{
                    if(key == 0){
                        System.out.println("A is Running");
//                        System.out.println("A is Running");
                        i--;
                        key = 1;
                        c.signal();
                    }else{
                        c.awaitUninterruptibly();
                    }

                }
                finally{
                    l.unlock();
                }
            }
        }

    }

    class B implements Runnable{
        @Override
        public void run() {
            int i = 10;
            while(i > 0){
                l.lock();
                try{
                    if(key == 1){
                        System.out.println("B is Running");
                        i--;
                        key = 2;
                        c.signal();
                    }else{
                        c.awaitUninterruptibly();
                    }

                }
                finally{
                    l.unlock();
                }
            }
        }
    }

    class C implements Runnable{
        @Override
        public void run() {
            int i = 10;
            while(i > 0){
                l.lock();
                try{
                    if(key == 2){
                        System.out.println("C is Running");
                        i--;
                        key = 0;
                        c.signal();
                    }else{
                        c.awaitUninterruptibly();
                    }

                }
                finally{
                    l.unlock();
                }
            }
        }
    }
}
