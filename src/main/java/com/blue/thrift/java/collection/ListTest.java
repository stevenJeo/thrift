package com.blue.thrift.java.collection;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zs on 2019/12/26.
 */
public class ListTest {


    public static void main(String[] sss) {

        int n = 7;
        int c = 0;

        while (n > 1) {
            if (n % 2 != 0) {
                c++;
            }
            n = n / 2;
            c++;
        }
        System.out.println(c);


    }


//    public static void main(String[] sss) {
//
////        TestObject s = new TestObject();
//
//        List a = new ArrayList<TestObject>(2);
//        TestObject ts = new TestObject(2);
//        a.add(ts);
//        a.add(new TestObject(3));
////        a.contains();
//
//        List b = new ArrayList<TestObject>(a);
//
////        List copy = Lists.newArrayList(a);
//
////        a.add(new TestObject(5));
//
//        System.out.println(a.get(0));
//        System.out.println(b.get(0));
//        System.out.println("=======1====");
////
////        TestObject testObject = (TestObject) a.get(0);
////        testObject.setValue(6);
//
//        ((TestObject) a.get(0)).setValue(6);
//        System.out.println(a.get(0));
//        System.out.println(b.get(0));
//        System.out.println("======2=====");
//
//
////        a.add(0, new TestObject(7));
////        b.add(0, new TestObject(7));
////        System.out.println(a.get(0));
////        System.out.println(b.get(0));
////        System.out.println("======3=====");
//
//
////        a.remove(0);
//        b.remove(0);
//
//        System.out.println(a.get(0));
//        System.out.println(b.get(0));
//
//    }


}
