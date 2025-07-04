package com.xsq.lang.features.internet.TCP;

import java.io.*;
import java.net.Socket;

/*
 * 文件上传
 * */
// 客户端
public class Client03 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10001);

        //是本地的流,用来读取本地文件的.
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("JavaBase\\src\\com\\xsq\\internet\\TCP\\1.png"));

        //写到服务器 --- 网络中的流
        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);

        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);//通过网络写到服务器中
        }
        bos.flush();
        //给服务器一个结束标记,告诉服务器文件已经传输完毕
        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        bis.close();
        socket.close();
    }
}