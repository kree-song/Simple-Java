package com.xsq.juc.thread.create;

import java.util.concurrent.Callable;

/*
 * 线程实现方式三：实现Callable接口
 * */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("跟女孩表白" + i);
        }
        //返回值表示线程运行完毕之后的结果
        return "答应";
    }
}
