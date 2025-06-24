package com.xsq.lang.oop.lambda.whpu;

public class AnonimousImpl {   //annoimous--匿名的
    public static void main(String[] args) {
        //2.通过匿名内部类实现接口
        IFormala formala = new IFormala() {
            @Override
            public double getResult(int a) {
                return a * a;
            }
        };

        //3.lamda表达式
        IFormala formala2 = (a) -> {
            return a * a;
        };

        //4.lamda表达式
        IFormala formala3 = a -> a * a;
        System.out.println("显式实现：" + new FormalaImpl().getResult(3));
        System.out.println("匿名内部类实现：" + formala.getResult(3));
        System.out.println("lamda表达式实现：" + formala2.getResult(3));
        System.out.println("lamda表达式实现2：" + formala3.getResult(3));
    }
}
