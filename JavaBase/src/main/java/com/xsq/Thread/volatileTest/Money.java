package com.xsq.Thread.volatileTest;

// Volatile关键字 : 强制线程每次在使用的时候，都会看一下共享区域最新的值
public class Money {
    public static volatile int money = 100000;
}