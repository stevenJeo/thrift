package com.blue.thrift.io.nio;

import com.blue.thrift.io.nio.handler.AcceptEventHandler;
import com.blue.thrift.io.nio.handler.ReadEventHandler;
import com.blue.thrift.io.nio.handler.WriteEventHandler;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by zhouzhishuai on 2017/5/16.
 */
public class NIOtest {

    public static void main(String[] args)throws Exception{
        //对指定端口打开一个通道
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.socket().bind(new InetSocketAddress(8180));
        serverChannel.configureBlocking(false);

        ReactorSimple reactor = new ReactorSimple();
        //给该通道注册不同的事件类型
        reactor.registerChannel(SelectionKey.OP_ACCEPT, serverChannel);
//        reactor.registerChannel(SelectionKey.OP_READ, serverChannel);
//        reactor.registerChannel(SelectionKey.OP_WRITE, serverChannel);

        reactor.registerEvenHandler(SelectionKey.OP_ACCEPT, new AcceptEventHandler(reactor.getSelector()));
        reactor.registerEvenHandler(SelectionKey.OP_READ, new ReadEventHandler(reactor.getSelector()));
        reactor.registerEvenHandler(SelectionKey.OP_WRITE, new WriteEventHandler(reactor.getSelector()));

        reactor.run();
    }

}

