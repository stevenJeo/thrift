package com.blue.thrift.algorithm;

/**
 * 二分查找
 */
public class BinarySearch {


    public static int search(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;

            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] ass) {
        int[] arr = {-1, 0, 3, 5, 9, 12};

        System.out.println(search(arr, 9));
    }


}
