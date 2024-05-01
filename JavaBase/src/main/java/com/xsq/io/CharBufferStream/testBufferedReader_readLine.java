package com.xsq.io.CharBufferStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * 字符缓冲输入流特有方法：readLine():读一整行
 * */
public class testBufferedReader_readLine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("JavaBase\\src\\com\\xsq\\io\\CharStream\\a.txt"));

        String line;
        //可以读取一整行数据，读到换行符为止
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}
