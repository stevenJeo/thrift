//package com.blue.thrift.javasist;
//
//import javassist.util.proxy.MethodFilter;
//import javassist.util.proxy.MethodHandler;
//import javassist.util.proxy.ProxyFactory;
//
//import java.lang.reflect.Method;
//
///**
// * Created by zhouzhishuai on 2017/5/29.
// */
//public class JavasistAOP {
//
//    public static void main(String[] args) throws Exception {
//        ProxyFactory factory = new ProxyFactory();
//        factory.setSuperclass(JavassistClass.class);
//        //设置过滤器，判断哪些方法需要被拦截
//        factory.setFilter(new MethodFilter() {
//            @Override
//            public boolean isHandled(Method method) {
//                if (method.getName().equals("getName")) {
//                    return true;
//                }
//                return false;
//            }
//        });
//        //设置拦截后的处理链
////        factory.
//        factory.setHandler(new MethodHandler() {
//            @Override
//            public Object invoke(Object self, Method thisMethod, Method proceed, Object[] args) throws Throwable {
//                JavassistClass o = (JavassistClass) self;
//                o.setName("invoke..");
//                System.out.println("preHandle..." + "\n");
//                Object result = proceed.invoke(self, args);
//                System.out.println("afterHandle..." + "\n");
//                return result;
//            }
//        });
//
//        Class<?> c = factory.createClass();
//        JavassistClass obj = (JavassistClass) c.newInstance();
//        System.out.println(obj.getName());
//
//    }
//
//}
//
////class JavassistClass {
////    private String name = "default";
////
////    public JavassistClass() {
////        name = "me";
////    }
////
////    public String getName() {
////        return name;
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
////
////    public void execute() {
////        System.out.println(name);
////        System.out.println("execute ok");
////    }
////}
