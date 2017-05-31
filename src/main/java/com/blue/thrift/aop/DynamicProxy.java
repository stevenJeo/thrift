package com.blue.thrift.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhouzhishuai on 2017/5/24.
 */
public class DynamicProxy implements InvocationHandler{

    private Object target;

    DynamicProxy(Object object){
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = method.invoke(proxy, args);

        return result;
    }

    Object getProxyIncetance(){

        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), this);

    }


}
