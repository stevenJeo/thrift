package com.blue.thrift.io.nio;

import com.blue.thrift.io.nio.handler.AcceptEventHandler;
import com.blue.thrift.io.nio.handler.ReadEventHandler;
import com.blue.thrift.io.nio.handler.WriteEventHandler;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.TreeSet;

/**
 * Created by zhouzhishuai on 2017/5/16.
 */
public class NIOtest {

    public static void main(String[] args) throws Exception {
        ReactorSimple reactor = new ReactorSimple(Selector.open());
        Selector selector = reactor.getSelector();

        //对指定端口打开一个通道
        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        serverChannel.socket().bind(new InetSocketAddress(8180));
        serverChannel.configureBlocking(false);

        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
//        serverChannel.register(selector, SelectionKey.OP_READ);


        //通道2
        ServerSocketChannel serverChannel_2 = ServerSocketChannel.open();
        int ops = serverChannel_2.validOps();//通道上监听的那些I/O事件类型，如：OP_READ|OP_WRITE，则validOps()方法的返回值为5（00101）
        serverChannel_2.socket().bind(new InetSocketAddress(8080));
        serverChannel_2.configureBlocking(false);

//      ReactorSimple reactor = new ReactorSimple();
//        this.selector = Selector.open();



//        serverChannel.register(reactor.getSelector(), SelectionKey.OP_CONNECT);
        serverChannel.register(reactor.getSelector(), SelectionKey.OP_ACCEPT);
//        serverChannel.register(reactor.getSelector(), SelectionKey.OP_READ);


//        serverChannel_2.register(reactor.getSelector(), SelectionKey.OP_ACCEPT);


        //给该通道注册不同的事件类型
//        reactor.registerChannel(SelectionKey.OP_ACCEPT, serverChannel);
//        reactor.registerChannel(SelectionKey.OP_READ, serverChannel);
////        reactor.registerChannel(SelectionKey.OP_WRITE, serverChannel);
//
//        //在selector上注册通道——2
//        reactor.registerChannel(SelectionKey.OP_ACCEPT, serverChannel_2);
////        reactor.registerChannel(SelectionKey.OP_READ, serverChannel_2);
//        reactor.registerChannel(SelectionKey.OP_WRITE, serverChannel_2);

        reactor.registerEvenHandler(SelectionKey.OP_ACCEPT, new AcceptEventHandler(reactor.getSelector()));
        reactor.registerEvenHandler(SelectionKey.OP_READ, new ReadEventHandler(reactor.getSelector()));
        reactor.registerEvenHandler(SelectionKey.OP_WRITE, new WriteEventHandler(reactor.getSelector()));

        reactor.run();


        Thread.currentThread().interrupt();


    }

}

