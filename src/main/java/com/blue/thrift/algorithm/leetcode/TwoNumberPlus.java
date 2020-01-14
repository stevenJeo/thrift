package com.blue.thrift.algorithm.leetcode;

/**
 * Created by zhishuai.zhou on 2020/1/5.
 */
public class TwoNumberPlus {


    public static void main(String[] ss) {
//        ListNode l1 = initListNode(new int[]{2, 4, 3, 1});
//        ListNode l2 = initListNode(new int[]{5, 6, 4});


        for(int i=0; i<5; ){
            System.out.println(i++);
        }

        for(int i=0; i<5; ){
            System.out.println(++i);
        }



//        ListNode l1 = initListNode(new int[]{5});
//        ListNode l2 = initListNode(new int[]{5});
//
//
//        System.out.println(listStr(l1));
//        System.out.println(listStr(l2));
//
//        System.out.println(listStr(addTwoNumbers(l1, l2)));
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode out = null;
        ListNode indexNode = null;
        boolean hasNext = true;
        int pw = 0;

        while (hasNext) {
            int l1v = 0;
            if (l1 != null) {
                l1v = l1.val;
                l1 = l1.next;
            }
            int l2v = 0;
            if (l2 != null) {
                l2v = l2.val;
                l2 = l2.next;
            }
            int tmp = l1v + l2v + pw;
            pw = tmp / 10;

            indexNode = appendNode(indexNode, tmp % 10);
            if (out == null) {
                out = indexNode;
            }

            hasNext = l1 != null | l2 != null | pw > 0;
        }
        return out;
    }

    private static ListNode appendNode(ListNode indexNode, int val) {
        ListNode tmpNode = new ListNode(val);
        if (indexNode != null) {
            indexNode.next = tmpNode;
        }
        return tmpNode;
    }

    private static ListNode initListNode(int[] ls) {
        ListNode tmp = null;
        ListNode out = null;
        for (int val : ls) {
            if (tmp == null) {
                tmp = new ListNode(val);
                out = tmp;
            } else {
                tmp.next = new ListNode(val);
                tmp = tmp.next;
            }
        }
        return out;
    }

    private static String listStr(ListNode out) {
        String str = "";
        while (out != null) {
            str = str + out.val;
            out = out.next;
        }
        return str;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
