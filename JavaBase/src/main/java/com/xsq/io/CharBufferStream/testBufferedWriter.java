package com.xsq.io.CharBufferStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/*
 * 字符缓冲输出流：将数据高效写出
 * */
public class testBufferedWriter {
    public static void main(String[] args) throws IOException {
        //创建字符缓冲输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("JavaBase\\src\\com\\xsq\\io\\CharStream\\a.txt"));

        //写出数据
        bw.write(97);
        bw.write("\r\n");

        char[] chars = {97, 98, 99, 100, 101};
        bw.write(chars);
        bw.newLine();

        bw.write(chars, 0, 3);
        bw.write("\r\n");

        String str = "你好，世界";
        bw.write(str);
        bw.write("\r\n");

        bw.write(str, 0, 4);

        //刷新、关闭资源
        bw.flush();
        bw.close();

    }
}
