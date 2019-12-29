package com.blue.thrift.ispring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by zs on 2017/6/11.
 */
public class IocImpleTest {


        public static void main(String[] args){
            BeanFactory f0 = new XmlBeanFactory(new FileSystemResource("fileUrl"));//简单IOC容器

            BeanFactory f1 = new ClassPathXmlApplicationContext("..xmlBeanFactory/.");//ApplicationContext高级IOC容器
//            BeanFactory f2 = new ApplicationContext();
//            new XmlWebApplicationContext("s");
        }




}
