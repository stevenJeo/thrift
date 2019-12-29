package com.blue.thrift.java.collection;

/**
 * Created by zhishuai.zhou on 2019/12/26.
 */
public class TestObject {


    private int value;

    public TestObject() {

    }

    public TestObject(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }


}
