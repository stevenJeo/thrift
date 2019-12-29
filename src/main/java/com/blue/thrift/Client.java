package com.blue.thrift;

import com.blue.thrift.service.Hello;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by zs on 2017/4/13.
 */
public class Client {
    public void startClient() throws Exception {
        try {
            System.out.println("thrift client connext server at 1234 port ");
            TTransport transport = new TSocket("localhost", 1234);
            TProtocol protocol = new TBinaryProtocol(transport);

            Hello.Client client = new Hello.Client(protocol);

            transport.open();
            for (int i = 0; i < 1000; i++) {
                System.out.println(client.helloString("client: pgs"));
                System.out.println("\n sleep ...");
                Thread.sleep(1000L);
            }

            transport.close();
            System.out.println("thrift client close connextion");
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("thrift client init ");
        Client client = new Client();
        System.out.println("thrift client start ");
        client.startClient();
        System.out.println("thrift client end ");
    }
}
