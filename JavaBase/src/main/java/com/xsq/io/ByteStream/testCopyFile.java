package com.xsq.io.ByteStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*使用字节流进行文件拷贝*/
public class testCopyFile {
    public static void main(String[] args) throws IOException {
        //method1();
        //method2();
    }

    private static void method2() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\itheima\\a.avi");
        FileOutputStream fos = new FileOutputStream("bytestream\\a.avi");

        //核心原理：一次读写多个字节
        byte[] bytes = new byte[1024];
        int len;//记录本次读到的有效字节个数

        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }

        fis.close();
        fos.close();
    }

    private static void method1() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\itheima\\a.avi");
        FileOutputStream fos = new FileOutputStream("bytestream\\a.avi");

        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }
        fis.close();
        fos.close();
    }

}
