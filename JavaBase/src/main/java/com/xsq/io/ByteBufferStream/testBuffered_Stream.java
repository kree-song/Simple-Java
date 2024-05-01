package com.xsq.io.ByteBufferStream;

import java.io.*;

/*
 * 使用缓冲流进行文件拷贝
 * */
public class testBuffered_Stream {
    public static void main(String[] args) throws IOException {
        //method1();
        //method2();
    }

    private static void method2() throws IOException {
        //创建一个字节缓冲输入流
        //在底层创建了一个默认长度为8192的字节数组
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\itheima\\a.avi"));
        //创建一个字节缓冲输出流
        //在底层也创建了一个默认长度为8192的字节数组
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("bytestream\\a.avi"));

        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        bis.close();
        bos.close();
    }

    private static void method1() throws IOException {
        //创建一个字节缓冲输入流
        //在底层创建了一个默认长度为8192的字节数组
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\itheima\\a.avi"));
        //创建一个字节缓冲输出流
        //在底层也创建了一个默认长度为8192的字节数组
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("bytestream\\a.avi"));

        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }

        //方法底层会把字节流关闭
        bis.close();
        bos.close();
    }
}
