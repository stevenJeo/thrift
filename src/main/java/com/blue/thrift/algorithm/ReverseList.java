package com.blue.thrift.algorithm;

/**
 * 反转链表
 */
public class ReverseList {



    public static void main(String[] ss){


//        ListNode init = initList();


    }

//    private static ListNode initList(){
//
//        ListNode node_1 = new ListNode(1);
//        ListNode node_2 = new ListNode(1);
//        ListNode node_3 = new ListNode(1);
//        ListNode node_4 = new ListNode(1);
//        ListNode node_5 = new ListNode(1);
//
//        node_1.setNext(node_2);
//
//    }





    public static class ListNode{
        private int val;
        private ListNode next;

        public ListNode(int val){
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }


}
