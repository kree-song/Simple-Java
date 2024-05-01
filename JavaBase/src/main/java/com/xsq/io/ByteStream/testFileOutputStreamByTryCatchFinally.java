package com.xsq.io.ByteStream;

import java.io.FileOutputStream;
import java.io.IOException;

/*字节流写数据，处理异常*/
public class testFileOutputStreamByTryCatchFinally {
    public static void main(String[] args) {
        FileOutputStream fos = null;//防止finally不可用此变量
        try {
            //System.out.println(2/0);
            fos = new FileOutputStream("JavaBase\\src\\com\\xsq\\io\\a.txt", true);
            fos.write(97);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //finally语句里面的代码，一定会被执行
            if (fos != null) {//防止出现ByZero异常后，再出现空指针异常
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
