package com.blue.thrift.newObject;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ObjectOutputStream;

/**
 * Created by zhouzhishuai on 2017/5/11.
 */
public class NewObject {

    public static void main(String[] args)throws Exception{
        System.out.print("new a object test....\n");

        //方法一：new
        TestNewObeject tt = new TestNewObeject();
        System.out.print("1. new a object: " + tt.getE()+"\n");

        //方法二：class.newInstance()
        TestNewObeject t2 = TestNewObeject.class.newInstance();
        System.out.print("2. \n class.newInstance():" + t2.getE()+"\n");
        TestNewObeject t3 = (TestNewObeject)Class.forName("com.blue.thrift.newObject.TestNewObeject").newInstance();
        System.out.print("Class.forName():" + t3.getE()+"\n");

        //方法三：从已有的对象clone一个对象
        //旧对象需要实现cloneable接口，注意深浅复制的区别
        TestClone.main(new String[]{""});

        //方法四：从序列化中重建一个对象
        ByteOutputStream btout = new ByteOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(btout);
        out.writeObject(t2);

    }


}


class TestNewObeject{

    private int e = 7;

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }



}