package com.blue.thrift.service.impl;

import com.blue.thrift.service.Hello;
import org.apache.thrift.async.AsyncMethodCallback;

/**
 * Created by zhouzhishuai on 2017/4/13.
 */
public class HelloAsyncImpl implements Hello.AsyncIface {

    public void helloString(String word, AsyncMethodCallback callback){
        //todo 服务端异步实现，放到队列中排队执行？？？
    }
}
