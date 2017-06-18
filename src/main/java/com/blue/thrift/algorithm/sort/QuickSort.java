package com.blue.thrift.algorithm.sort;

/**
 * Created by zhouzhishuai on 2017/5/22.
 */
public class QuickSort {

    public static void main(String[] args) {
//        int[] a = new int[]{6, 2, 8, 3, 3, 1, 7, 8, 9, 0, 4};
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};


        System.out.print("[ before quick sort ] ..." + "\n" + printArray(a) + "\n");
        quick_sort(a, 0, a.length - 1);

        System.out.print("[ after quick sort ]..." + "\n" + printArray(a) + "\n");
    }

    public static String printArray(int[] a) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (a.length - 1 == i) {
                str.append(a[i]);
            } else {
                str.append(a[i] + ",");
            }
        }
        return str.toString();
    }


    public static void quick_sort(int[] a, int l, int r) {
        if (l < r) {
            int i = adjust(a, l, r);
//            quick_sort(a, l, i - 1);//左支递归
//            quick_sort(a, i + 1, r);//右支递归
        }
    }

    public static int adjust(int[] a, int left, int right) {
        int i = left;//i第一次开始为0
        int j = right;
        while (i < j) {
            int x = a[i];//基准数提出

            //从右向左找
            while (i < j && a[j] >= x)//j一直向左找,相等的留前边
                j--;
            if (i < j) {
                a[i] = a[j];
                i++;//标志位i后移
            }

            //从左向右找
            while (i < j && a[i] < x)
                i++;
            if (i < j) {
                a[j] = a[i];
                j--;//标志j位前移
            }

            //i=j,遍历结束
//            a[i] = x;
        }
        return i;//返回基准数当前坐标
    }

}
