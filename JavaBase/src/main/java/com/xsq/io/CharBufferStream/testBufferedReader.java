package com.xsq.io.CharBufferStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * 字符缓冲输入流:将数据高效读入
 * */
public class testBufferedReader {
    public static void main(String[] args) throws IOException {
        //创建字符缓冲输入流
        BufferedReader br = new BufferedReader(new FileReader("JavaBase\\src\\com\\xsq\\io\\CharStream\\a.txt"));
        //读取数据
        char[] chars = new char[1024];
        int len;
        while ((len = br.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));
        }
        //关闭资源
        br.close();
    }
}
