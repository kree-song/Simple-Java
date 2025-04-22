package com.xsq.languageBase.OOP.lambda;

interface ShowHandler {
    void show();
}

/*
 * 函数式编程：强调做什么
 * Lambda格式：(形式参数)->{代码块}
 * 使用前提：1）有一个接口 2）接口中有且仅有一个抽象方法
 * Lambda表达式的省略模式：
 *  1）参数类型可以省略，但是有多个参数的情况下，不能只省略一个
 *  2）如果参数有且仅有一个，纳么小括号可以省略
 *  3）如果代码块的语句只有一条，可以省略大括号和分号，甚至是return
 * */
public class testLambda {
    public static void main(String[] args) {
        useShowHandler(new ShowHandler() {
            @Override
            public void show() {
                System.out.println("我是匿名内部类中的show方法");
            }
        });

        //lambda
        useShowHandler(() -> {
            System.out.println("我是lambda中的show方法");
        });
    }

    public static void useShowHandler(ShowHandler showHandler) {
        showHandler.show();
    }
}
