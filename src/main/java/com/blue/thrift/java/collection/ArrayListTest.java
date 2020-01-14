package com.blue.thrift.java.collection;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zs on 2020/1/5.
 */
public class ArrayListTest {


    public static void main(String[] args) {

        // 初始化一个list，放入5个元素
        final List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        System.out.println("list：" + JSON.toJSONString(list));


        // 线程一：通过Iterator遍历List,会出现快速出错机制
        new Thread(new Runnable() {
            @Override
            public void run() {
//                for(int item : list) {

//                int size = list.size();
//                for (int i = 0; i < size; i++) {
//                    int item = list.get(i);

                Iterator itr = list.iterator();
                while (itr.hasNext()) {
                    int item = (Integer) itr.next();


                    System.out.println("遍历元素：" + item);
                    // 由于程序跑的太快，这里sleep了1秒来调慢程序的运行速度
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // 线程二：remove一个元素
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 由于程序跑的太快，这里sleep了1秒来调慢程序的运行速度
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                list.remove(1);
                System.out.println("list.remove(4)");
            }
        }).start();
    }
}
