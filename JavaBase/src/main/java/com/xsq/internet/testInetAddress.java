package com.xsq.internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class testInetAddress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("127.0.0.1");

        String hostName = address.getHostName();
        System.out.println("主机名：" + hostName);
        String hostAddress = address.getHostAddress();
        System.out.println("IP：" + hostAddress);
    }
}
