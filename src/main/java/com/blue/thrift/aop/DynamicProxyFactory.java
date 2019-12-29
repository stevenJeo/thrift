package com.blue.thrift.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zs on 2017/5/24.
 */
public class DynamicProxyFactory implements InvocationHandler {

    private Object target;

    DynamicProxyFactory(Object object) {
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("proxy before ....");

        Object result = method.invoke(target, args);

        System.out.println("proxy after ....");

        return result;
    }


    public Object getProxyInstance() {
//        Class[] interfaces = {target.getClass().getInterfaces()[1]};
//
//        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
//                interfaces, this);

        Object proxyInstance = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), this);

        return proxyInstance;
    }


}
