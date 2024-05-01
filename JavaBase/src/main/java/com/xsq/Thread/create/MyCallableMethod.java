package com.xsq.Thread.create;

import java.util.concurrent.Callable;

public class MyCallableMethod implements Callable<String> {

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
        }
        return "线程执行完毕";
    }
}
