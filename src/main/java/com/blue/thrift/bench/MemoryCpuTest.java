package com.blue.thrift.bench;

/**
 * Created by zs on 2017/4/20.
 */
public class MemoryCpuTest {

    public static void main(String[] args) throws InterruptedException {

        cpuFix();
    }


    /**
     * cpu 运行固定百分比
     *
     * @throws InterruptedException
     */
    public static void cpuFix() throws InterruptedException {
        // 80%的占有率
        int busyTime = 8;
        // 20%的占有率
        int idelTime = 2;
        // 开始时间
        long startTime = 0;

        while (true) {
            // 开始时间
            startTime = System.currentTimeMillis();

            /*
             * 运行时间
             */
            while (System.currentTimeMillis() - startTime < busyTime) {
                ;
            }

            // 休息时间
            Thread.sleep(idelTime);
        }
    }
}
