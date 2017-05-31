package com.blue.thrift.ispring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by zhouzhishuai on 2017/5/18.
 */
public class MyFactoryBean implements FactoryBean {


    /**
     * T getObject()：返回由 FactoryBean 创建的 Bean 实例，
     * 如果 isSingleton() 返回 true ，则该实例会放到 Spring 容器中单实例缓存池中；
     *
     * 当配置文件中<bean> 的 class 属性配置的实现类是 FactoryBean 时，
     * 通过 getBean() 方法返回的不是 FactoryBean 本身，而是 FactoryBean#getObject() 方法所返回的对象，
     * 相当于 FactoryBean#getObject() 代理了 getBean() 方法。
     * @return
     * @throws Exception
     */
    @Override
    public Object getObject() throws Exception {//返回factoryBean通过getObject(&..)
        BeanFactoryUtils.isFactoryDereference("");//判断一个bean是否是FactoryBean
//        BeanFactory

        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
