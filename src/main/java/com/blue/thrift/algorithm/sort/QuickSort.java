package com.blue.thrift.algorithm.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zhouzhishuai on 2017/5/22.
 */
public class QuickSort {

//    public static void main(String[] args) {
////        int[] a = new int[]{6, 2, 8, 3, 3, 1, 7, 8, 9, 0, 4};
//        Integer a[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
//
//
//        System.out.print("[ before quick sort ] ..." + "\n" + StringUtil.printArray(a) + "\n");
//        quick_sort(a, 0, a.length - 1);
//
//        System.out.print("[ after quick sort ]..." + "\n" + StringUtil.printArray(a) + "\n");
//    }


    public static void quick_sort(Integer[] a, int l, int r) {
        if (l < r) {
            int i = adjust(a, l, r);
            quick_sort(a, l, i - 1);//左支递归
            quick_sort(a, i + 1, r);//右支递归
        }
    }

    public static int adjust(Integer[] a, int left, int right) {
        int i = left;//i第一次开始为0
        int j = right;
        while (i < j) {
            int x = a[i];//基准数提出

            //从右向左找
            //j一直向左找,相等的留前边
            while (i < j && a[j] >= x) {
                j--;
                if (i < j) {
                    a[i] = a[j];
                    i++;//标志位i后移
                }
            }

            //从左向右找
            while (i < j && a[i] < x) {
                i++;
                if (i < j) {
                    a[j] = a[i];
                    j--;//标志j位前移
                }
            }
            //i=j,遍历结束
//            a[i] = x;
        }
        //返回基准数当前坐标
        return i;
    }

    //========================================= 实现二 ===========================================

    /**
     * 返回中位数下标，
     * 将数组中小于基准数的元素放在其左边，大于基准数的元素放在其右边
     */
    public static int setPivot(Integer[] arr, int left, int right) {

        while (left < right) {

            //从右向左找到小于基准数的坐标，并交换
            while (left < right && arr[left] <= arr[right]) {
                right--;
            }
            swap(arr, left, right);


            //从左向右找到大于基准数的坐标，并交换
            while (left < right && arr[left] <= arr[right]) {
                left++;
            }
            swap(arr, left, right);
        }

        return left;
    }

    /**
     * 交换指定坐标的两个元素
     */
    private static void swap(Integer[] arr, int left, int right) {
        if (!arr[left].equals(arr[right])) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
    }


    /**
     * 传统快排实现
     * 取数组中第一个元素为基准
     */
    public static void quickSort(Integer[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = setPivot(arr, left, right);

            quickSort(arr, left, pivotIndex - 1);

            quickSort(arr, pivotIndex + 1, right);
        }
    }

    /**
     * 快排优化
     * <p>
     * 随机选取基准数放在第一位作交换
     */
    public static void QSort(Integer[] arr) {
        int randPivotIndex = new Random().nextInt(arr.length);
//        System.out.println(arr[randPivotIndex]);
//        swap(arr, 0, randPivotIndex);

        quickSort(arr, 0, arr.length - 1);
    }


    public static void main(String[] sss) {
//        Integer[] arr = {5, 6, 1, 3, 7, 5, 2, 9, 4, 8};
//        Integer[] arr = {5, 2, 6, 4, 1, 3, 7};

//        String ss = "abcdef";
//
//        String as = ss.substring(1, 3);
//
//        int[] sssad = {2,21,41};
//
//
//        Integer arr[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

//        int p = parti(arr, 0, arr.length - 1);


            int[] fushu = {-2, -3, 5, 8, -4, 2, -3, 7, 12, -88, -23, 35};

        setParted(fushu);
        System.out.println("\n");
        setParted1(fushu,0,fushu.length-1);
    }



   private static void fuzi(int[] a){

        int fu = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] < 0){
                int tmp = a[i];
                a[i] = a[fu];

            }
            if(a[i] > 0){
                fu++;
            }

        }

    }




    public static void setParted(int[] a){
//        int temp=0;
        int border = -1;

        for(int cur = 0; cur < a.length; cur++){
            if(a[cur] < 0){
                int temp = a[cur];

                a[cur] = a[border + 1];

                a[border + 1] = temp;
                border++;
            }
        }
        for(int j=0;j<a.length;j++){
            System.out.print(a[j] + ",");
        }
    }



    public static void setParted1(int[] a,int left,int right){
        if(left>=right||left==a.length||right==0){
            for(int i=0;i<a.length;i++){
                System.out.println(a[i]);
            }
            return ;
        }
        while(a[left]<0){
            left++;
        }
        while(a[right]>=0){
            right--;
        }
        if(left>=right||left==a.length||right==0){
            for(int i=0;i<a.length;i++){
                System.out.print(a[i]+",");
            }
            return;
        }
        swap(a,left,right);
        left++;
        right--;
        setParted1(a,left,right);
    }
    private static void swap(int a[],int left,int right){
        int temp=0;
        temp=a[left];
        a[left]=a[right];
        a[right]=temp;
    }
//    public static void main(String[] args) {
//        int a[]={1,2,-1,-5,-6,7,-7,-10};
//        new PartTest().setParted1(a,0,a.length-1);
//    }


}
