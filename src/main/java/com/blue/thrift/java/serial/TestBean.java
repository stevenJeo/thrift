package com.blue.thrift.java.serial;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * Created by zs on 2019/12/29.
 */
public class TestBean implements Serializable {

    private static final long serialVersionUID = -4185768776647143366L;
    private String name;
    private int age;
    private int num;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    ///


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "name=" + name + ",age=" + age;
    }


    public String transJsonStr() {
        return JSON.toJSONString(this);

    }
}
