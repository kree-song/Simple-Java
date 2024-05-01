package com.xsq.lambda;

interface Calculator {
    int calc(int a, int b);
}

//既有参数又有返回值
public class testLambda04 {
    public static void main(String[] args) {
        useCalculator(new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        });

        //使用Lambda
        useCalculator((int a, int b) -> {
            return a + b;
        });
    }

    public static void useCalculator(Calculator calculator) {
        int result = calculator.calc(10, 20);
        System.out.println(result);
    }
}
