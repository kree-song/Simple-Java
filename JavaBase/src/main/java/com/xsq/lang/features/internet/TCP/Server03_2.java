package com.xsq.lang.features.internet.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/*
 * 用循环改写：使得服务器端可以处理多个用户请求
 * UUID：UUID.randomUUID()方法生成随机的文件名，解决二次上传时会覆盖前面文件的问题
 * */
// 服务器
public class Server03_2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);

        while (true) {
            Socket accept = ss.accept();

            //网络中的流,从客户端读取数据的
            BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
            //本地的IO流,把数据写到本地中,实现永久化存储
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("JavaBase\\src\\com\\xsq\\internet\\TCP\\" + UUID.randomUUID().toString() + ".png"));

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
        }
        //ss.close();
    }
}