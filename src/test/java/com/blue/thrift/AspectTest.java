package com.blue.thrift;

import com.blue.thrift.web.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * Created by zhishuai.zhou on 2018/8/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring.xml"})
//@Slf4j
public class AspectTest {

    @Resource
    HomeController homeController;

    @Test
    public void LogTest() throws Exception {
        System.out.println("sssssss");
        homeController.haveLog("param");

        homeController.nonLog("param");

        homeController.common("com");
    }
}
