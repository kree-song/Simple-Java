package com.xsq.lang.oop.lambda;

interface StringHandler {
    void printMessage(String msg);
}

/*
 * 带参数的lambda
 * */
public class testLambda02 {
    public static void main(String[] args) {
        useStringHandler(new StringHandler() {
            @Override
            public void printMessage(String msg) {
                System.out.println("我是匿名内部类 " + msg);
            }
        });

        //lambda实现
        useStringHandler((String msg) -> {
            System.out.println("我是Lambda " + msg);
        });
    }

    public static void useStringHandler(StringHandler stringHandler) {
        stringHandler.printMessage("zhangsan");
    }
}