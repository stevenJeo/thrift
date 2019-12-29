package com.blue.thrift.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * Created by zs on 2017/6/12.
 *
 * java中的引用级别：强引用 > 软引用 > 弱引用 > 虚引用
 *
 */
public class ReferenceTest {

    public static void main(String[] args){

        String str = new String("abc");//强引用
        WeakReference<String> weakReference = new WeakReference<String>(str);//弱引用
        SoftReference<String> softReference = new SoftReference<String>(str);//软引用
//        PhantomReference<String> phantomReference = new PhantomReference<String>(str, new ReferenceQueue());//虚引用


        String str2 = weakReference.get();//再次变为强引用



    }

}
