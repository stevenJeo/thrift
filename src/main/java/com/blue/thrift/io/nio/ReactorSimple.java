package com.blue.thrift.io.nio;

import com.blue.thrift.io.nio.handler.AcceptEventHandler;
import com.blue.thrift.io.nio.handler.ReadEventHandler;
import com.blue.thrift.io.nio.handler.WriteEventHandler;
import javafx.event.EventHandler;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 参考： https://github.com/kasun04/rnd/tree/master/nio-reactor
 * Created by zhouzhishuai on 2017/5/16.
 */
public class ReactorSimple {

    private Selector selector;
    private Map<Integer, EventHandler> registers = new ConcurrentHashMap<Integer, EventHandler>();

    public ReactorSimple()throws Exception{
        selector = Selector.open();
    }
    public Selector getSelector(){
        return selector;
    }

    public void registerEvenHandler(int evenType, EventHandler eventHandler){
        registers.put(evenType, eventHandler);
    }
    public void registerChannel(int eventType, SelectableChannel channel)throws Exception{
        channel.register(selector, eventType);
    }

    public void run(){
        while(true){
            try {
                int rr = selector.select();
                Set<SelectionKey> keys = selector.selectedKeys();//阻塞获取事件
                Iterator<SelectionKey> it = keys.iterator();

                while (it.hasNext()){
                    SelectionKey selectionKey = it.next();
//                    selectionKey.channel()

                    //遍历事件类型，分派给指定处理链
                    if(selectionKey.isAcceptable()){//新连接
                        AcceptEventHandler eventHandler = (AcceptEventHandler)registers.get(SelectionKey.OP_ACCEPT);
                        eventHandler.handleEvent(selectionKey);//需要event类型事件
                        it.remove();
                    }
                    if(selectionKey.isReadable()){//可读事件
                        ReadEventHandler eventHandler = (ReadEventHandler)registers.get(SelectionKey.OP_READ);
                        eventHandler.handleEvent(selectionKey);
                        it.remove();
                    }
                    if(selectionKey.isWritable()){//可写事件
                        WriteEventHandler eventHandler = (WriteEventHandler)registers.get(SelectionKey.OP_WRITE);
                        eventHandler.handleEvent(selectionKey);
                        it.remove();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
