package com.xsq.io.CharBufferStream;

import java.io.*;

/*
 * 将文件中的数据读取并写入到另一个文件
 * */
public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("JavaBase\\src\\com\\xsq\\io\\CharStream\\a.txt"));
        //当续写开关为false时，会清空文件内容，建议读取到流后再进行输出流的创建
        BufferedWriter bw = new BufferedWriter(new FileWriter("JavaBase\\src\\com\\xsq\\io\\CharStream\\a.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
