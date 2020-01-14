package com.blue.thrift.algorithm.leetcode;

import com.blue.thrift.algorithm.sort.StringUtil;

/**
 * Created by zhishuai.zhou on 2020/1/8.
 */
public class MaxMinNum {
    /**
     * 给出一个整数，141543，
     * 求大于这个数的最小值，即143145
     * 思路：
     * 从右向左找到第一个[下标为i]比最后一位小的值，并与最后一位值交换，对i后的数据从小到大排序。
     */

    public static void main(String[] ss) {

//        int n = 141543;

//        int[] ns = new int[]{1, 4, 1, 5, 4, 3};

        int[] ns = new int[]{1, 4, 3, 5, 1, 3};

        setNum(ns);

    }

    private static void setNum(int[] ns) {

        int len = ns.length;
        int min = ns[len - 1];

        int s = -1;
        for (int i = len - 2; i > 0; i--) {
            if (ns[i] < min) {
                s = i;
                int tmp = ns[i];
                ns[i] = ns[len - 1];
                ns[len - 1] = tmp;
                break;
            }
        }

        //数据不存在
        if (s == -1) {
            return;
        }

        //剩余数字正序排序
        int[] nx = new int[len - s - 1];
        int nsi = len - 1;
        for (int a = 0; a < len - s - 1; a++) {
            nx[a] = ns[nsi--];
        }

        //排序 i+1到 len-1 的数字
        int nxi = 0;
        for (s = s + 1; s < len; s++) {
            ns[s] = nx[nxi++];
        }
        System.out.println(StringUtil.printArray(ns));

//        return ns;
    }


}
