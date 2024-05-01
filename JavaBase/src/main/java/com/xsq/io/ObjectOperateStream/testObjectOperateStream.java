package com.xsq.io.ObjectOperateStream;

import java.io.*;

/*
 * 对象操作流的特点：可以把对象以字节的形式写到本地文件，直接打开文件是读不懂的，需要再次用对象操作流读到内存中
 * 对象操作输出流(ObjectOutputStream,对象序列化流)：就是将对象写到本地文件中，或者在网络中传输对象
 * 对象操作输入流(ObjectInputStream,对象反序列化流)：把写到本地文件中的对象读到内存中，或者接收网络中传输的对象
 * */
public class testObjectOperateStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        testObjectOutputStream();
        testObjectInputStream();

    }

    private static void testObjectInputStream() throws IOException, ClassNotFoundException {
        //对对象进行反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("JavaBase\\src\\com\\xsq\\io\\CharStream\\a.txt"));
        User u = (User) ois.readObject();
        System.out.println(u);
        ois.close();
    }

    private static void testObjectOutputStream() throws IOException {
        //对对象进行序列化
        User user = new User("zhangsan", "qwer");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("JavaBase\\src\\com\\xsq\\io\\CharStream\\a.txt"));
        oos.writeObject(user);
        oos.close();
    }
}
