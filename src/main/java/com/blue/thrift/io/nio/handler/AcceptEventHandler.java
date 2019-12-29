package com.blue.thrift.io.nio.handler;

import javafx.event.Event;
import javafx.event.EventHandler;

import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by zs on 2017/5/16.
 */
public class AcceptEventHandler implements EventHandler {

    private int t = 0;

    public void handle(Event event) {
        event.getEventType();
    }

    private Selector demultiplexer;

    public AcceptEventHandler(Selector demultiplexer) {
        this.demultiplexer = demultiplexer;
    }

    public void handleEvent(SelectionKey handle) throws Exception {
//        System.out.println("===== Accept Event Handler =====");
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) handle.channel();

//        System.out.println("..handle.isReadable()=" + handle.isReadable() + ", handle.isWritable()" + handle.isWritable());

        SocketChannel socketChannel = serverSocketChannel.accept();
        SocketAddress localAddress = socketChannel.getLocalAddress();
        SocketAddress remoteAddress = socketChannel.getRemoteAddress();
        System.out.println("\n" + "localAddress:" + localAddress.toString()
                + ", remoteAddress:" + remoteAddress.toString()
                + ", channel:" + handle.channel() + "\n");

        if (socketChannel != null) {
            socketChannel.configureBlocking(false);
//            System.out.println("===== Accept Event Handler..channel =====");
//            if (t < 1) {
                socketChannel.register(demultiplexer, SelectionKey.OP_READ);
//                t++;
//            }
//            if(t==1){
//                socketChannel.register(demultiplexer, SelectionKey.OP_WRITE);
//                t++;
//            }

//            socketChannel.register(demultiplexer, SelectionKey.OP_WRITE);
        }

    }

}
