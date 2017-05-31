package com.blue.thrift.tst;

import com.blue.thrift.HelloAsyncClient;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhouzhishuai on 2017/5/8.
 */
public class TestMain {


    public static void main(String[] args){
        int i = -7;

        System.out.print(i+", i.Binary="+Integer.toBinaryString(i) + "\n");
        int j = i>>>2;

        System.out.print(j+", j.Binary="+Integer.toBinaryString(j) + "\n");



        String shippingmethods = "";
//        String shippingmethods = "22,33,2243,";
        System.out.print(shippingmethods);
//        for(ShippingMethod ship : address.getShippingmethods()){
//            shippingmethods = ship.getShippingmethodname() + ",";
//        }
//        if(shippingmethods.length()>0){
//            shippingmethods = shippingmethods.substring(0, shippingmethods.length()-1);
//        }
//        System.out.print("\n "+shippingmethods);

        String ss = shippingmethods.length() > 0 ? shippingmethods.substring(0, shippingmethods.length() - 1) : "";
        System.out.print("\n "+ss);
    }



}
