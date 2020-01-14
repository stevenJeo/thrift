package com.blue.thrift.java.serial.fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.blue.thrift.java.serial.TestBean;

/**
 * Created by zhishuai.zhou on 2019/12/29.
 */
public class JsonTest {


    public static void main(String[] ss) {
        TestBean bean = new TestBean();
        bean.setName("james");
        bean.setAge(27);

        String beanStr = JSON.toJSONString(bean);

        JSON.toJSONString(bean);

        System.out.println(beanStr);


        TestBean desBean = JSON.parseObject(beanStr, TestBean.class);

        System.out.println(JSON.toJSONString(desBean));

//        IdentityHashMap
//        SerializeConfig

    }


}
