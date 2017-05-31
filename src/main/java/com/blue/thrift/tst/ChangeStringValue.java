package com.blue.thrift.tst;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Field;

/**
 * Created by zhouzhishuai on 2017/5/17.
 */
public class ChangeStringValue {


    public static void main(String[] args) throws Exception{
        //String是不可变的，String类中的value是用final修饰的

        String s = "12345";
        System.out.print("s=" + s + ", s.hashCode=" + s.hashCode() + "\n");
        String s1 = s.replace("3", "f");
        System.out.print("s1=" + s1 + ", s1.hashCode=" + s1.hashCode() + "\n");

        //用反射改变不可变对象String的值
        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);
        char[] value = (char[])field.get(s);
        value[2] = 'f';
        System.out.print("reflect change String , \n s=" + s + ", s.hashCode=" + s.hashCode() + "\n");

    }

}
