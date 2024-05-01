package com.xsq.io.ByteStream;

import java.io.FileOutputStream;
import java.io.IOException;

/*
- 如果操作的是纯文本文件,优先使用字符流
- 如果操作的是图片、视频、音频等二进制文件,优先使用字节流
- 如果不确定文件类型,优先使用字节流.字节流是万能的流
* */
/*字节流写数据*/
public class testFileOutputStream {
    public static void main(String[] args) throws IOException {
        //1.创建字节输出流的对象
        //注意：若文件不存在，会自动创建；若文件存在，会把文件内容清空
        //第二个参数就是续写开关，默认为false
        FileOutputStream fos = new FileOutputStream("JavaBase\\src\\com\\xsq\\io\\ByteStream\\a.txt", true);
        //2.写数据，传递一个整数时，实际写到文件中的是这个整数在码表中对应的那个字符
        fos.write(97);
        fos.write("\r\n".getBytes());
        fos.write(98);
        fos.write("\r\n".getBytes());
        fos.write(99);
        //3.释放资源
        fos.close();
    }
}
