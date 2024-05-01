package com.xsq.io.ObjectOperateStream;

import java.io.*;
import java.util.ArrayList;

/*
 * 保存对象、读出对象
 * */
public class test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User u1 = new User("zhangsan", "abc");
        User u2 = new User("lisi", "def");
        User u3 = new User("wangwu", "ghi");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("JavaBase\\src\\com\\xsq\\io\\CharStream\\a.txt"));
        /*oos.writeObject(u1);
        oos.writeObject(u2);
        oos.writeObject(u3);*/
        ArrayList<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        oos.writeObject(list);

        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("JavaBase\\src\\com\\xsq\\io\\CharStream\\a.txt"));
        /*Object obj;
        while ((obj=ois.readObject())!=null){
            System.out.println(obj);
        }*/

        /*//方式一
        while (true){
            try {
                Object o=ois.readObject();
                System.out.println(o);
            } catch (EOFException e) {
                break;
            }
        }*/

        //方式二
        ArrayList<User> list2 = (ArrayList<User>) ois.readObject();
        for (User user : list2) {
            System.out.println(user);
        }
        ois.close();
    }
}
