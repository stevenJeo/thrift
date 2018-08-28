package com.blue.thrift.web;

import com.blue.thrift.aspect.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhishuai.zhou on 2018/8/27.
 */
@Controller
@RequestMapping({"/base/home/v1", "/base/home/v2"})
public class HomeController {

    @RequestMapping(value = "/haveLog")
    @Log(durationPrint = true)
    public String haveLog(String ps) throws Exception {
        Thread.sleep(1000);
        return "haveLog !";
    }

    @Log
    @RequestMapping(value = "/nonLog")
    public String nonLog(String ps) {
        return "nonLog !";
    }

    @Log
    public String common(String com) {
        return "common method !";
    }

}
