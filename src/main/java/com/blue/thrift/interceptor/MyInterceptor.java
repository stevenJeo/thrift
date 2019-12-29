package com.blue.thrift.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zs on 2017/5/15.
 */
public class MyInterceptor extends HandlerInterceptorAdapter{//继承适配器不需要实现接口中的每一个方法

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean validate = false;
        Map<String, String> paramMap= URLAnalyzer.getParamMap(request);
        //获取httpRequest中的参数，进行校验
        return validate;
    }



}
class URLAnalyzer {
    public static Map<String, String> getParamMap(HttpServletRequest req) {
        Map<String, String> paramMap = new HashMap<String, String>();
        Enumeration paramNames = req.getParameterNames();
        String key;
        String[] value;
        while (paramNames.hasMoreElements()) {
            key = (String) paramNames.nextElement();
            value = req.getParameterValues(key);
            if (value != null && value.length == 1) {
                paramMap.put(key, value[0]);
            } else {
                StringBuffer tmp = new StringBuffer();
                int len = value.length;
                for (int i = 0; i < len; i++) {
                    if (i > 0) tmp.append(";");
                    tmp.append(value[i]);
                }
                paramMap.put(key, tmp.toString());
            }
        }
        paramMap.remove("$r");
        paramMap.remove("$v");
        return paramMap;
    }


}
