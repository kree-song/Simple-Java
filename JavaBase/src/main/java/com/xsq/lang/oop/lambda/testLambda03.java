package com.xsq.lang.oop.lambda;

import java.util.Random;

interface RandomNumHandler {
    int getNumber();
}

//有返回值的Lambda
//如果lambda所操作的接口中的方法有返回值，一定要通过return语句将结果返回，否则会出现编译错误
public class testLambda03 {
    public static void main(String[] args) {
        useRandomNumHandler(new RandomNumHandler() {
            @Override
            public int getNumber() {
                Random r = new Random();
                int num = r.nextInt(10) + 1;//1-10
                return num;
            }
        });

        //使用Lambda
        useRandomNumHandler(() -> {
            Random r = new Random();
            int num = r.nextInt(10) + 1;//1-10
            //如果lambda所操作的接口中的方法有返回值，一定要通过return语句将结果返回，否则会出现编译错误
            return num;
        });
    }

    public static void useRandomNumHandler(RandomNumHandler randomNumHandler) {
        int result = randomNumHandler.getNumber();
        System.out.println(result);
    }
}
