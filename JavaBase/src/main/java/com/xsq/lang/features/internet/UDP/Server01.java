package com.xsq.lang.features.internet.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * 1.要先运行接收端，再运行发送端
 * 2.如果接收端再启动后，没有接收到数据，那么会死等(阻塞)
 * 3.在接收数据的时候，需要调用一个getLength方法，表示接收到了多少字节
 * */
public class Server01 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10000);

        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        System.out.println("---------接收前----------");
        ds.receive(dp);
        System.out.println("---------接收后----------");
        //byte[] data= dp.getData();
        int length = dp.getLength();
        System.out.println(new String(bytes, 0, length));
        ds.close();
    }
}
