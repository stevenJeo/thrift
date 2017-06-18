package com.blue.thrift.algorithm.sort;

/**
 * Created by zhouzhishuai on 2017/5/22.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] s = new int[]{6, 2, 8, 3, 3, 1, 7, 8, 9, 0, 4};
        print(s);
        quick_sort(s, 0, s.length - 1);

        print(s);

    }

    static void print(int[] s) {
        for (int i = 0; i < s.length; i++) {
            if(0==i)
                System.out.print("\n"+s[i] + ",");
            else{
                System.out.print(s[i] + ",");
            }
        }
    }

    public static void quick_sort(int[] s, int l, int r) {
        if (l < r) {
            int i = adjust(s, l, r);
            quick_sort(s, l, i - 1);//左支递归
            quick_sort(s, i + 1, r);//右支递归
        }
    }

    public static int adjust(int[] s, int left, int right) {
        int i = left;//i第一次开始为0
        int j = right;
        while (i < j) {
            int x = s[i];//基准数提出

            //从右向左找
            while (i < j && s[j] >= x)//j一直向左找,相等的留前边
                j--;
            if (i < j) {
                s[i] = s[j];
                i++;//标志位i后移
            }

            //从左向右找
            while (i < j && s[i] < x)
                i++;
            if (i < j) {
                s[j] = s[i];
                j--;//标志j位前移
            }

            //i=j,遍历结束
            s[i] = x;
        }
        return i;//返回基准数当前坐标
    }

}
