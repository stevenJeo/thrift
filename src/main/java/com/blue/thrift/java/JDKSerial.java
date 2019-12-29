package com.blue.thrift.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by zhishuai.zhou on 2019/12/29.
 */
public class JDKSerial {


    public static void main(String[] ass) throws Exception {

        TestBean bean = new TestBean();
        bean.setAge(28);
        bean.setName("james");
        bean.setNum(34);

        String filePath = "./src/main/java/com/blue/thrift/java/serialObject.txt";

//        serialObject(filePath, bean);

        deSerialObject(filePath);

    }


    /**
     * 序列化
     */
    private static void serialObject(String filePath, TestBean bean) throws Exception {
        FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
        objectOutputStream.writeObject(bean);
        objectOutputStream.close();
        fos.close();
    }


    /**
     * 反序列化
     */
    private static void deSerialObject(String filePath) throws Exception {
        FileInputStream fin = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fin);
        TestBean deserialObject = (TestBean) objectInputStream.readObject();

        System.out.println(deserialObject);

        objectInputStream.close();
        fin.close();
    }


}
