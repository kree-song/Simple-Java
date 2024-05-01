package com.xsq.io.ObjectOperateStream;

import java.io.Serializable;

//如果想要这个类的对象能被序列化，那么这个类必须实现Serializable接口
//Serializable接口:标记型接口，里面没有任何抽象方法；只要实现了这个接口，就表示这个类的对象可以被序列化

/*
 * serialVersionUID:序列号
 * 如果没有自定义，那么虚拟机会根据类中的信息自动计算出一个序列号；若修改了类中信息，那么虚拟机会再次计算出一个序列号
 *
 * 异常过程：1）把User对象序列化到本地
 *         2）修改JavaBean类，导致序列号改变
 *         3）把文件中的对象读到内存，本地中的序列号和类中的序列号不一致了
 * 解决办法：不让虚拟机计算序列号，自己手动给出，而且这个值不要变
 *
 * 若对象中某个成员变量的值不想被序列化：用transient关键字修饰该成员变量，该关键字标记的成员变量不参与序列化过程
 * */

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String passsword;

    public User() {
    }

    public User(String username, String passsword) {
        this.username = username;
        this.passsword = passsword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", passsword='" + passsword + '\'' +
                '}';
    }
}
