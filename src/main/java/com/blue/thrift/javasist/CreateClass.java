package com.blue.thrift.javasist;

import javassist.*;

import java.lang.reflect.Method;

/**
 * Created by zhouzhishuai on 2017/5/29.
 */
public class CreateClass {

    //用javasist动态构造一个类，在运行时可以复用该类的信息，用反射方法可实例化一个对象，并执行类中的方法。
    //在性能上Javassist高于反射，但低于ASM，因为Javassist增加了一层抽象。
    // 在实现成本上Javassist和反射都很低，而ASM由于直接操作字节码，相比Javassist源码级别的api实现成本高很多。
    // 几个方法有自己的应用场景，比如Kryo使用的是ASM，追求性能的最大化。而NBeanCopyUtil采用的是Javassist，
    // 在对象拷贝的性能上也已经明显高于其他的库，并保持高易用性。实际项目中推荐先用Javassist实现原型，
    // 若在性能测试中发现Javassist成为了性能瓶颈，再考虑使用其他字节码操作方法做优化。
    //性能上：ASM > javassist > 反射
    public static void main(String[] args) throws Exception {
//        String className = "com.blue.thrift.javasist.JavassistClass";
        String className = "com.blue.JavassistClass";

        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass(className);

        StringBuilder str;
        //类中的属性字段， 1：属性类型  2：属性名称  3：所属类CtClass
        CtField ctField = new CtField(pool.get("java.lang.String"), "name", ctClass);
        ctField.setModifiers(Modifier.PRIVATE);
        //设置name属性的get/set方法及默认值
        ctClass.addMethod(CtNewMethod.setter("setName", ctField));
        ctClass.addMethod(CtNewMethod.getter("getName", ctField));
        ctClass.addField(ctField, CtField.Initializer.constant("default"));

        //类的构造函数  1：参数类型   2：所属类CtClass
        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{}, ctClass);
        str = new StringBuilder();
        str.append("{\n name=\"me\";\n}");
        ctConstructor.setBody(str.toString());
        ctClass.addConstructor(ctConstructor);

        //构造类中的方法：  1：返回类型  2：方法名称  3：传入参数类型  4：所属类CtClass
        CtMethod  ctMethod = new CtMethod(CtClass.voidType, "execute", new CtClass[]{}, ctClass);
        ctMethod.setModifiers(Modifier.PUBLIC);
        str = new StringBuilder();
        str.append("{\n System.out.println(name);");
        str.append("\n System.out.println(\"execute ok\");");
        str.append("\n return ;");
        str.append("\n}");
        ctMethod.setBody(str.toString());
        ctClass.addMethod(ctMethod);

        Class<?> c = ctClass.toClass();
        //调用字节码生成类的execute方法,用反射方法
        Object o = c.newInstance();
        Method method = o.getClass().getMethod("execute", new Class[]{});
        method.invoke(o, new Object[]{});

        //常规使用反射的方式
        Class cls = Class.forName(className);
        Object o2 = cls.newInstance();
        Method method2 = o2.getClass().getMethod("getName");
        System.out.print(method2.invoke(o2));
    }





}

//通过javasist构造的类应该和下面的信息一致
//public class JavassistClass{
//    private String name="default";
//    public JavassistClass(){
//        name="me";
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public void execute(){
//        System.out.println(name);
//        System.out.println("execute ok");
//    }
//}
