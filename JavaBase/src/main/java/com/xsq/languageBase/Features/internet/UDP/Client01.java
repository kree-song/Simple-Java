package com.xsq.languageBase.Features.internet.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client01 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        String s = "你好，UDP";
        byte[] bytes = s.getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);

        ds.send(dp);
        ds.close();


    }
}
