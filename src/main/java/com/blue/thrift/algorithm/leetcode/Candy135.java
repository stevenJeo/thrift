package com.blue.thrift.algorithm.leetcode;

/**
 * Created by zs on 2020/1/5.
 */
public class Candy135 {


    public static void main(String[] ss) {

        System.out.println(System.identityHashCode(null));

        int[] sc = new int[]{1, 2, 87, 87, 87, 2, 1};//13
//        int[] sc = new int[]{1, 0, 2};//5
//        int[] sc = new int[]{1, 3, 4, 5, 2};//11
//        int[] sc = new int[]{1, 2, 3, 1, 0};//9

//        int[] sc = new int[]{0, 1, 2, 3, 2, 1};//13

        System.out.println(candy(sc));
    }

    public static int candy(int[] ratings) {
        int len = ratings.length;
        int[] pra = new int[len];

        pra[0] = 1;
        int i = 0;
        for (int j = i + 1; j < len; ) {

            if (ratings[j] > ratings[j - 1]) {
                pra[j] = pra[j - 1] + 1;
                i = j;
                j++;
            } else if (ratings[j] == ratings[j - 1]) {
                i = j;
                pra[j] = 1;
                j++;
            } else if (ratings[j] < ratings[j - 1]) {
                if (pra[j - 1] > 1) {
                    pra[j] = 1;
                    i = j;
                    j++;
                } else {

                    while (j < len && ratings[j] < ratings[j - 1]) {
                        j++;
                    }

                    pra[i] = j - i;

                    while (++i < len && i < j) {
                        pra[i] = pra[i - 1] - 1;
                    }

                }
            }
        }

        int sum = 0;
        for (int s = 0; s < len; s++) {
            sum += pra[s];
        }
        return sum;
    }
}
