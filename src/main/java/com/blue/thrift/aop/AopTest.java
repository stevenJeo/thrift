package com.blue.thrift.aop;

import sun.misc.ProxyGenerator;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by zhouzhishuai on 2017/5/24.
 */
public class AopTest implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

//        JMenuBar
//        ArrayBlockingQueue
//        method.invoke();
//        Proxy.newProxyInstance();


        Object result = method.invoke(proxy, args);

        return result;
    }


    public static void main(String[] ss) throws Exception {

        Player player = new Player("james");

        Method method = Player.class.getMethod("playBall", String.class);


        method.invoke(player, "hashsas");


        DynamicProxyFactory proxyFactory = new DynamicProxyFactory(player);
//
        Play proxyPlayer = (Play) proxyFactory.getProxyInstance();
//
//        Class[] in = player.getClass().getInterfaces();
//
////        System.out.println(proxyPlayer.playBall());
//
//        Class proxyPlayerClass = proxyPlayer.getClass();
//
//        proxyPlayer.playBall("basketball");
//        proxyPlayer.playHappy();
//
//
        ClassPrint.proxy(null, proxyPlayer.getClass().getInterfaces());


    }


}
