package com.xsq.io.ByteStream;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * 测试字节输入流，读取文件中一个字节
 * */
public class testFileInputStream {
    public static void main(String[] args) throws IOException {
        //若文件不存在，会报FileNotFoundException
        FileInputStream fis = new FileInputStream("JavaBase\\src\\com\\xsq\\io\\ByteStream\\a.txt");
        //一次读取一个字节数据，返回值就是本次读到的那个字节数据，也就是字符在码表中对应的那个数据
        int read = fis.read();
        System.out.println(read);
        //若想要看到字符数据，可以强转
        System.out.println((char) read);
        System.out.println((char) fis.read());
    }
}
