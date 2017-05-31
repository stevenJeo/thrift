package com.blue.thrift.interceptor;

//import com.letv.payment.controller.SignValidateIntercepter;
//import com.letv.xice.core.configuration.GlobalDateFormatJsonConfiguration;
//import com.letv.xice.core.configuration.RestTemplateConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by zhangshunsheng on 2017/1/6.
 */
@Configuration
//@Import({GlobalDateFormatJsonConfiguration.class,RestTemplateConfiguration.class})
public class WebConfig extends WebMvcConfigurerAdapter {


    @Bean
    MyInterceptor myIntercepter() {
        return new MyInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myIntercepter()).
                addPathPatterns("/payment/backendNotice",
                        "/payment/frontNotice",
                        "/refund/onlineNotice");//注册需要拦截的url

    }
}
