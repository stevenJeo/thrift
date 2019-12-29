package com.blue.thrift.java.thread.pool;

import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhouzhishuai on 2017/7/5.
 */
public class ScheduleThreaPoolExecutorTest {

    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static class TimerTask implements Runnable{
        private String id;
        public TimerTask(String id){
            this.id = id;
        }
        @Override
        public void run(){
            System.out.println(df.format(System.currentTimeMillis())  + "\n");
        }
    }



    public static void main(String[] args) throws Exception{
        System.out.print("ssss");

        //定时任务线程池，池子中的线程定时执行任务
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
        ScheduledFuture sfa = ses.scheduleAtFixedRate(new TimerTask("a"), 200,2000, TimeUnit.MILLISECONDS);
//        ScheduledFuture sfb = ses.scheduleAtFixedRate(new TimerTask("b"), 400,1000, TimeUnit.MILLISECONDS);
//        ScheduledFuture sfc = ses.scheduleAtFixedRate(new TimerTask("c"), 600,1000, TimeUnit.MILLISECONDS);
//        ScheduledFuture sfd = ses.scheduleAtFixedRate(new TimerTask("d"), 800,1000, TimeUnit.MILLISECONDS);

//        Thread.sleep(5000);
//        sfa.cancel(true);
//        Thread.sleep(5000);
//        ses.shutdown();

    }

}
