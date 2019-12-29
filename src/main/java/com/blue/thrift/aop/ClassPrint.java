package com.blue.thrift.aop;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * Created by zhishuai.zhou on 2019/12/28.
 */
public class ClassPrint {


    public static void proxy(String path, Class[] classes) {
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", classes);

        path = "./Player$Proxy0.class";

        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (
                Exception e)

        {
            System.out.println("写文件错误");
        }


    }


}
