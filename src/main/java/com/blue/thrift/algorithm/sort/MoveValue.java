package com.blue.thrift.algorithm.sort;

/**
 * Created by zs on 2019/12/28.
 */
public class MoveValue {


    private static void sortA(int[] arr) {
        int i = 0;
        int len = arr.length;

        while (i < len && arr[i] < 0) {
            i++;
        }
        //i是第一个大于0的数
        if (i == len - 1) {
            return;
        }

        for (int j = i; j < len; j++) {
            if (arr[j] < 0) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                i++;
            }
        }


    }


    public static void setParted(Integer[] a) {
        int temp = 0;
        int border = -1;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                temp = a[i];
                a[i] = a[border + 1];
                a[border + 1] = temp;
                border++;
            }
        }
//        for (int j = 0; j < a.length; j++) {
//            System.out.println(a[j]);
//        }
    }


    public static void main(String[] ss) {
//
        int[] as = {3, 10, -2, 5, 8, -4, 2, -3, 7, 12, -88, -23, 35};
//
////        Integer[] as = {-2};
//
////        setParted(as);
        sortA(as);
//
        System.out.println(StringUtil.printArray(as));

        System.out.println(cut(5));
    }


    private static int cut(int n) {
        if (n <= 1) {
            return 0;
        } else {

            int l = n / 2;
            int r = n - l;

            return cut(Math.min(l, r)) + (l != r ? 2 : 1);
        }
    }

}
