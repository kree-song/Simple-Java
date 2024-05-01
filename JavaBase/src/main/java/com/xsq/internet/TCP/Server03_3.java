package com.xsq.internet.TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 用循环改写：使得服务器端可以处理多个用户请求
 * UUID：UUID.randomUUID()方法生成随机的文件名，解决二次上传时会覆盖前面文件的问题
 * */
// 服务器
public class Server03_3 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);

        while (true) {
            Socket accept = ss.accept();
            ThreadSocket ts = new ThreadSocket(accept);
            new Thread(ts).start();
        }
        //ss.close();
    }
}