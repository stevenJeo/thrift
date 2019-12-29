package com.blue.thrift.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 日志打印切面处理
 * <p>
 * Created by zs on 2018/8/27.
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    private ObjectMapper objectMapper = new ObjectMapper();


    @Pointcut("@annotation(com.blue.thrift.aspect.Log)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Class targetClass = joinPoint.getTarget().getClass();
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Log log = (Log) method.getAnnotation(Log.class);
        if (log == null) {
            return joinPoint.proceed();
        }

        String method_location = targetClass.getName() + "#" + method.getName();
        LOGGER.info("invoke_method={}", method_location);

        StopWatch stw = null;
        if (log.durationPrint()) {
            stw = new StopWatch(method_location);
            stw.start();
        }

        if (null != targetClass.getAnnotation(Controller.class)) {
            List<String> list = getUrl(targetClass, method);
            LOGGER.info("request_url={}", objectMapper.writeValueAsString(list));
        }

        LOGGER.info("param={}", objectMapper.writeValueAsString(joinPoint.getArgs()));

        Object result = joinPoint.proceed();

        if (log.durationPrint() && null != stw) {
            stw.stop();
            LOGGER.info("{}", stw.shortSummary());
        }

        if (log.resultPrint()) {
            LOGGER.info("result={}", result);
        }
        return result;
    }

    /**
     * controller中的方法
     * 拼接 URL
     *
     * @param targetClass
     * @param method
     * @return
     * @throws Exception
     */
    private List<String> getUrl(Class targetClass, Method method) throws Exception {
        List<String> urls = new ArrayList<String>();

        RequestMapping methodMapping = (RequestMapping) method.getAnnotation(RequestMapping.class);
        String[] m_paths = methodMapping != null ? methodMapping.value() : null;

        RequestMapping classMapping = (RequestMapping) targetClass.getAnnotation(RequestMapping.class);
        String[] c_paths = classMapping != null ? classMapping.value() : null;

        if (null == c_paths) {
            return Arrays.asList(m_paths);
        }
        for (String cp : c_paths) {
            if (null == m_paths) return Arrays.asList(c_paths);

            for (String mp : m_paths) {
                urls.add(cp + mp);
            }
        }
        return urls;
    }


}
