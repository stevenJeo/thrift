package com.blue.thrift.jdk8;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouzhishuai on 2017/7/20.
 */
public class StreamTest {


    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        list.add("111");
        list.add("222");

        System.out.print(list.stream().filter(p -> p.equals("222")).findFirst());

        List<Integer> nums = Lists.newArrayList(1,1,null,2,3,4,null,5,6,7,8,9,10);
        System.out.println("sum is:"+nums.stream().filter(num -> num != null)
                .distinct()
                .mapToInt(num -> num * 2)
                .peek(System.out::println)
                .skip(2)
                .limit(4)
                .sum());
//sheshasdhajs
    }

}
