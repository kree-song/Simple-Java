package com.xsq.juc.Thread.create;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class testMyCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //线程开启之后需要执行里面的call方法
        MyCallable mc = new MyCallable();
        //可以获取线程执行完毕之后的结果，也可以作为参数传递给Thread对象
        FutureTask<String> ft = new FutureTask<>(mc);
        Thread t1 = new Thread(ft);
        t1.start();
        //获得线程运行之后的结果；若线程还未结束，那么get()会在这里死等
        String s = ft.get();
        System.out.println(s);
    }
}
