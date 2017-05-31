package com.blue.thrift.io.nio.handler;

import javafx.event.Event;
import javafx.event.EventHandler;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * Created by zhouzhishuai on 2017/5/16.
 */
public class WriteEventHandler implements EventHandler {

    public void handle(Event event){

    }
    private Selector demultiplexer;
    public WriteEventHandler(Selector demultiplexer) {
        this.demultiplexer = demultiplexer;
    }

    public void handleEvent(SelectionKey handle) throws Exception {
        System.out.println("===== Write Event Handler =====");

        SocketChannel socketChannel = (SocketChannel) handle.channel();


        ByteBuffer bb = ByteBuffer.wrap("Hello Client!\n".getBytes());

//        ByteBuffer inputBuffer = (ByteBuffer) handle.attachment();
//        socketChannel.write(inputBuffer);

        socketChannel.write(bb);
        socketChannel.close();
    }

}
