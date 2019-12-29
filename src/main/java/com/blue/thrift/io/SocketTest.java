package com.blue.thrift.io;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import sun.nio.ch.SelectorProviderImpl;

import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.locks.Lock;

/**
 * Created by zs on 2017/5/16.
 */
public class SocketTest {

    private ServerSocketChannel sc;
    private Selector selector;


    public void test() throws Exception {
//        Lock
        ServerSocket serverSocket = new ServerSocket();

        Socket socket = serverSocket.accept();
//        socket.
        ByteInputStream in = (ByteInputStream)socket.getInputStream();
        in.read();

//        Object
//        Thread
//        Selector s = new AbstractSelector() {
//        }
        selector = Selector.open();
        SelectionKey skey = sc.register(selector, SelectionKey.OP_ACCEPT);
//        HashMap
//                PROPAGATION
//                propagation
    }


}
