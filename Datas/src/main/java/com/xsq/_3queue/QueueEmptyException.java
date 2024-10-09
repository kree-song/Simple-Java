package com.xsq._3queue;

/*
 * 自定义队列为空的异常
 * 该异常是一个运行时异常，不需要开发人员进行预处理
 * RuntimeException的子类就是运行时异常
 * */
public class QueueEmptyException extends RuntimeException {
    public QueueEmptyException() {
    }

    //String参数传递的是异常信息
    public QueueEmptyException(String message) {
        super(message);
    }
}
