package com.blue.thrift.java;

import java.net.URLClassLoader;

/**
 * Created by zs on 2020/1/2.
 */
public class ClassLoaderTest {


    public static void main(String[] ss) {

        MyClassLoader myClassLoader = new MyClassLoader();

    }


    static class MyClassLoader extends ClassLoader {

        public MyClassLoader() {
            super();
        }

        public MyClassLoader(ClassLoader parent) {
            super(parent);
            Class aClass = ClassLoaderTest.class;

        }

    }

}
