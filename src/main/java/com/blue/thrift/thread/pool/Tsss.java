package com.blue.thrift.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhouzhishuai on 2017/7/11.
 */
public class Tsss {
    private static long initialDelay = 5000;
    private static long period = 1000;//http调用间隔
    private static ScheduledExecutorService executorService;


    static {
        Runnable versionCheckTask = new VersionCheckTask();
        executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(versionCheckTask, initialDelay, period, TimeUnit.MILLISECONDS);
    }
    private static volatile Tsss mInstance;

    public static Tsss getInstance() {
        if (mInstance == null) {
            synchronized (Tsss.class) {
                if (mInstance == null) {
                    mInstance = new Tsss();
                }
            }
        }
        return mInstance;
    }

    public void fastCheckModelVersion() {
        System.out.print("fastCheckModelVersion...");
    }




    static class VersionCheckTask implements Runnable {
        @Override
        public void run() {
            Tsss.getInstance().fastCheckModelVersion();
        }
    }

    public static void main(String[] args){
        System.out.print("start main..."+"\n");

    }

}
