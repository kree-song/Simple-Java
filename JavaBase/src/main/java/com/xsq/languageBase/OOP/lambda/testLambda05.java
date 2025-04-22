package com.xsq.languageBase.OOP.lambda;

interface Calculator02 {
    int calc(int a, int b);
}

/*
 * Lambda表达式的省略模式：
 *  1）参数类型可以省略，但是有多个参数的情况下，不能只省略一个
 *  2）如果参数有且仅有一个，纳么小括号可以省略
 *  3）如果代码块的语句只有一条，可以省略大括号和分号，甚至是return
 * */
public class testLambda05 {
    public static void main(String[] args) {
/*        useCalculator(new Calculator02() {
            @Override
            public int calc(int a, int b) {
                return a+b;
            }
        });*/

        //使用Lambda
        useCalculator((a, b) ->
                a + b
        );
    }

    public static void useCalculator(Calculator02 calculator02) {
        int result = calculator02.calc(10, 20);
        System.out.println(result);
    }
}