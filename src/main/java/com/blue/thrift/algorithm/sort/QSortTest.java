package com.blue.thrift.algorithm.sort;

import com.google.common.collect.Sets;

import java.util.*;

/**
 * Created by zhishuai.zhou on 2019/12/16.
 */
public class QSortTest {


    public static void swap(Integer[] arr, int i, int j) {
        if (arr[i] != (arr[j])) {
            Integer temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static int middleIndex(Integer[] arr, int left, int right) {
//        int i = left;
//        int j = right;

        while (left < right) {
            while (left < right && arr[left] <= arr[right]) {
                right--;
            }
            swap(arr, left, right);

            while (left < right && arr[left] <= arr[right]) {
                left++;
            }
            swap(arr, left, right);
        }
        return left;
    }


    public static void QSort(Integer[] arr, int left, int right) {
        while (left < right) {
//            int middle = middleIndex(arr, left, right);
            int middle = QuickSort.setPivot(arr, left, right);

            QSort(arr, left, middle - 1);

            QSort(arr, middle + 1, right);
        }
    }


    public static void main(String[] sss) {
//        Integer[] arr = {5, 6, 1, 3, 7, 5, 2, 9, 4, 8};
//        Integer[] arr = {5, 2, 6, 4, 1, 3, 7};

//        Integer arr[] = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};


//        QSort(arr, 0, arr.length - 1);
//        QuickSort.QSort(arr);
//
//        System.out.println(StringUtil.printArray(arr));


        int[] nums = new int[3];

//        System.out.println(StringUtil.printArray(productExceptSelf(nums)));

//        binaryTreePaths(null);




//        Set<Integer> set = Sets.newHashSet(2,3,43);
//         Iterator iterator = set.iterator();
//        int i = 0;
//        while (iterator.hasNext()){
//            nums[i++] =  ((Integer) iterator.next()).intValue();
//        }
//
//        System.out.println(nums);
//        set.toArray()

        Integer cursor = 0;
        Integer s = cursor;
        System.out.println(s);
        cursor = cursor+1;
        System.out.println(s);
        System.out.println("cursor="+cursor);
    }



    public int[] singleNumber(int[] nums) {

        Set<Integer> set = new HashSet<Integer>(2);
        int len = nums.length;
        for(int i = 0; i< len ; i++){
            Integer c = nums[i];
            if(set.contains(c)){
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        int s = set.size();
        int[] out = new int[s];
        int i = 0;
        Iterator iterator =  set.iterator();
        while(iterator.hasNext()){
            out[i] = ((Integer)iterator.next()).intValue();
//            iterator = iterator.next();
            i++;
        }
        return out;
    }
}
