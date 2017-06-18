package com.blue.thrift.algorithm.sort;

/**
 * Created by zhouzhishuai on 2017/6/18.
 *
 * 4、数据结构与算法
 (1)掌握线性表和树的特点并熟练运用。
 (2)掌握常用排序和查找算法：插入排序(直接插入排序、希尔排序)、选择排序(直接选择排序、堆排序)、
 交换排序(冒泡排序、快速排序)、归并排序，顺序查找、二分查找、哈希查找。
 (3) 熟练运用常见排序和查找算法思想解决编程问题。
 (4)了解几大基本算法：贪心算法、分治策略、动态规划。
 *
 */
public class BubbleSort {

    /**
     * 冒泡排序：
     * 【主思想】
     * 两遍for循环，通过一遍遍历比较，将最大（小）数挑出放在队首；
     * 第二遍将次大（小）数放在第二位置.....
     *
     * @param a
     */
    public static void doBubbleSort(int[] a) {
//        a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {//j 从 i后一位开始搜索
                if (a[i] < a[j]) {//降序排列，后边有比当前值大的数，交换
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
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

    public static void main(String[] args) {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

        System.out.print("[ before Bubble sort ] ..." + "\n" + printArray(a) + "\n");
        doBubbleSort(a);

        System.out.print("[ after Bubble sort ]..." + "\n" + printArray(a) + "\n");
    }


}
