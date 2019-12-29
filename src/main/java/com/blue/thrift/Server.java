package com.blue.thrift;

import com.blue.thrift.service.Hello;
import com.blue.thrift.service.impl.HelloImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.*;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.*;

/**
 * Created by zs on 2017/4/13.
 */
public class Server {

    public void startTSimpleServer(){
        try {
            System.out.println("start TSimpleServer...");
            TProcessor tProcessor = new Hello.Processor(new HelloImpl());
            TServerSocket serverTransport = new TServerSocket(1234);
            TServer.Args tArgs = new TServer.Args(serverTransport);
            tArgs.processor(tProcessor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());

            //简单的单线程服务模型，一般用于测试
            TServer server = new TSimpleServer(tArgs);

            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startTThreadPoolServer() {
        try {
            System.out.println("start TThreadPoolServer...");
            TProcessor process = new Hello.Processor(new HelloImpl());
            TServerSocket serverTransport = new TServerSocket(1234);
            TBinaryProtocol.Factory portFactory = new TBinaryProtocol.Factory(true, true);
            Args args = new Args(serverTransport);
            args.processor(process);
            args.protocolFactory(portFactory);

            //线程池服务模型，使用标准的阻塞IO，预先创建一组线程处理请求。
            TServer server = new TThreadPoolServer(args);

            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public void startTNonblockingServer(){
        try {
            System.out.println("start TNonblockingServer...");
            TProcessor process = new Hello.Processor(new HelloImpl());

            TNonblockingServerSocket tnbSocketTransport = new TNonblockingServerSocket(1234);
            TNonblockingServer.Args tnbArgs = new TNonblockingServer.Args(tnbSocketTransport);
            tnbArgs.processor(process);
            tnbArgs.transportFactory(new TFramedTransport.Factory());

            tnbArgs.protocolFactory(new TCompactProtocol.Factory());

            //使用非阻塞式IO，服务端和客户端需要制定TFramedTransport数据传输的方式
            TServer server = new TNonblockingServer(tnbArgs);

            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    public void startTHsHaServer(){
        try {
            System.out.println("start THsHaServer...");
            TProcessor process = new Hello.Processor(new HelloImpl());

            TNonblockingServerSocket tnbSocketTransport = new TNonblockingServerSocket(1234);
            THsHaServer.Args tnbArgs = new THsHaServer.Args(tnbSocketTransport);
            tnbArgs.processor(process);
            tnbArgs.transportFactory(new TFramedTransport.Factory());
            tnbArgs.protocolFactory(new TBinaryProtocol.Factory());

            //半同步半异步的服务模型
            TServer server = new THsHaServer(tnbArgs);

            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println("thrift server init");
        Server server = new Server();
        System.out.println("thrift server start");
//        server.startTSimpleServer();
        server.startTThreadPoolServer();
        System.out.println("thrift server end");
    }
}
