package com.xsq.juc.thread.example.BoundedBufferProblem2Object;

public class Desk {
    public static final Object objLock = new Object();
    public static boolean flag = false;
    public static int count = 10;
}
