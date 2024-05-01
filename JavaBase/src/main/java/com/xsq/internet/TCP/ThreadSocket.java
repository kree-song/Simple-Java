package com.xsq.internet.TCP;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class ThreadSocket implements Runnable {
    private Socket accept;

    public ThreadSocket(Socket accept) {
        this.accept = accept;
    }

    @Override
    public void run() {
        BufferedOutputStream bos = null;
        try {
            //网络中的流,从客户端读取数据的
            BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
            //本地的IO流,把数据写到本地中,实现永久化存储
            bos = new BufferedOutputStream(new FileOutputStream("JavaBase\\src\\com\\xsq\\internet\\TCP\\" + UUID.randomUUID().toString() + ".png"));

            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
            bw.write("上传成功");
            bw.newLine();
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
