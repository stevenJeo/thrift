package com.blue.thrift.java.newObject;

/**
 * Created by zhouzhishuai on 2017/5/11.
 */
public class TestClone {


    public static void main(String[] args){
        System.out.print("============shadow clone & deep clone============ \n");
        A a = new A(new B());

        //test shadow clone
        A a1 = (A)a.clone();
        System.out.print("shadow clone test: " +
                "\n a?=a1 : "+a.equals(a1)
                +", a.hashCode="+a.hashCode()+", a1.hashCode="+a1.hashCode()
                +"\n a.b?=a1.b : "+a.b.equals(a1.b)
                +", a.b.hashCode="+a.b.hashCode()+", a1.b.hashCode="+a1.b.hashCode());

        System.out.print("\n ------------------------------------ \n ");
        A a2 = (A)a.deepClone();
        System.out.print("deep clone test: " +
                "\n a?=a2 : "+a.equals(a2)
                +", a.hashCode="+a.hashCode()+", a2.hashCode="+a2.hashCode()
                +"\n a.b?=a2.b : "+a.b.equals(a2.b)
                +", a.b.hashCode="+a.b.hashCode()+", a2.b.hashCode="+a2.b.hashCode());


        //String 有个常量池，所以new 一个String时并没有新建字符串
//        String ts = "12345";
//        String tt = new String("12345");
//        System.out.print("ts.hashCode="+ts.hashCode()+", tt.hashCode="+tt.hashCode());

    }

}

class A implements Cloneable{
    private int a = 2;
    public B b;

    public A(B bb){
        this.b = bb;
    }

    //shadow clone
    @Override
    public Object clone(){
        System.out.print("this is shadow clone. \n");
        A a = null;
        try {
            a = (A)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return a;
    }

    public Object deepClone(){
        System.out.print("this is deep clone. \n");
        A a = null;
        try {
            a = (A)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        a.b = (B)b.clone();
        return a;
    }

}

class B implements Cloneable{
    private int bb = 3;

    @Override
    public Object clone(){
        System.out.print("this is shadow clone. \n");
        B b = null;
        try {
            b = (B)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return b;
    }
}