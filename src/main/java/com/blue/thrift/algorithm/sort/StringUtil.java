package com.blue.thrift.algorithm.sort;

import java.util.Arrays;

/**
 * Created by zhishuai.zhou on 2019/7/27.
 */
public class StringUtil {


    public static String printArray(Integer[] arr) {
        return Arrays.stream(arr)
                .map(s -> s.toString())
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
    }


}
