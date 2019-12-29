package com.blue.thrift;

import com.blue.thrift.service.Hello;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by zs on 2017/4/13.
 */
public class HelloAsyncClient {

    //异步客户端,非阻塞NIO？？？
    public void startAsyncClient(){
        try {
            TAsyncClientManager tAsyncClientManager = new TAsyncClientManager();
            TNonblockingTransport transport = new TNonblockingSocket("localhost",1234, 6000);
            TProtocolFactory tProtocol = new TCompactProtocol.Factory();
            Hello.AsyncClient asyncClient = new Hello.AsyncClient(tProtocol, tAsyncClientManager, transport);

            CountDownLatch latch = new CountDownLatch(1);
            AsyncMethodCallback callBack = new AsyncCallback(latch);

            System.out.println("call method sayHello start ...");
            asyncClient.helloString("", callBack);
            System.out.println("call method sayHello .... end");

            boolean wait = latch.await(30, TimeUnit.SECONDS);
            System.out.println("latch.await =:" + wait);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //客户端处理服务端的异步回告数据
    public class AsyncCallback implements AsyncMethodCallback<Hello.AsyncClient.helloString_call>{
        private CountDownLatch latch;

        public AsyncCallback(CountDownLatch latch){
            this.latch = latch;
        }

        @Override
        public void onComplete(Hello.AsyncClient.helloString_call response){
            System.out.print("onComplete...");
            try{
                //Thread.sleep(1000L * 1);
                System.out.println("AsynCall result =:" + response.getResult().toString());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        @Override
        public void onError(Exception exception) {
            System.out.println("onError :" + exception.getMessage());
            latch.countDown();
        }

    }

    public static void main(String[] args) {
        HelloAsyncClient client = new HelloAsyncClient();
        client.startAsyncClient();
    }

}
