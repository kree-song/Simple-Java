package com.xsq.io.ByteStream;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * 通过字节输入流，读取文件中多个字节
 * */
public class testFileInputStream02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("JavaBase\\src\\com\\xsq\\io\\a.txt");
        int b;
        while ((b = fis.read()) != -1) {
            System.out.print((char) b);
        }
    }
}
