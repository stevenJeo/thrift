package com.blue.thrift.java.concurrent;


import com.alibaba.fastjson.JSON;

import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by zs on 2020/1/4.
 */
public class CyclicBarrierTest implements Runnable {

    CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
    Executor pool = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    Map<String, Integer> map = new ConcurrentHashMap<String, Integer>();


    private void multiExecutor(int size) {
        for (int i = 0; i < 4; i++) {

            pool.execute(new Runnable() {

                @Override
                public void run() {

                    try {
                        map.put(Thread.currentThread().getName(), 10);

                        System.out.println(Thread.currentThread().getName() + " run ..." + cyclicBarrier.getParties());

                        cyclicBarrier.await();

                        System.out.println(Thread.currentThread().getName() + " run done..." + cyclicBarrier.getParties());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });

        }

    }


    @Override
    public void run() {

        int result = 0;

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            result += e.getValue();
        }
        map.put(Thread.currentThread().getName(), result);

        System.out.println(JSON.toJSON(map));
//        cyclicBarrier.reset();
    }

    public static void main(String[] ss) throws Exception {
        CyclicBarrierTest test = new CyclicBarrierTest();
        test.multiExecutor(4);

        test.run();

        Thread.sleep(3000);
        test.multiExecutor(4);






    }
}
