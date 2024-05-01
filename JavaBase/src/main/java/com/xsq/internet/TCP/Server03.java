package com.xsq.internet.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// 服务器
public class Server03 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);

        Socket accept = ss.accept();

        //网络中的流,从客户端读取数据的
        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
        //本地的IO流,把数据写到本地中,实现永久化存储
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("JavaBase\\src\\com\\xsq\\internet\\TCP\\copy.png"));

        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write("上传成功");
        bw.newLine();
        bw.flush();

        bos.close();
        accept.close();
        ss.close();
    }
}