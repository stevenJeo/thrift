package com.blue.thrift.service.impl;

import com.blue.thrift.service.Hello;
import org.apache.thrift.TException;

/**
 * Created by zs on 2017/4/13.
 */
public class HelloImpl implements Hello.Iface {
    private static int count = 0;
    @Override
    public String helloString(String word) throws TException {
        // TODO Auto-generated method stub
        count += 1;
        System.out.println("server " + word + " " +count);
        return "server: hello " + word + " " + count;
    }
}