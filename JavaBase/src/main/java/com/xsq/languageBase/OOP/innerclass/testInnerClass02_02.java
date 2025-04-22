package com.xsq.languageBase.OOP.innerclass;

interface Swimming {
    void swim();
}

public class testInnerClass02_02 {
    public static void main(String[] args) {
        goSwimming(new Swimming() {
            @Override
            public void swim() {
                System.out.println("一起游泳吧！");
            }
        });

        //使用lambda
        goSwimming(() -> {
            System.out.println("一起游泳吧！");
        });
    }

    //使用接口的方法
    public static void goSwimming(Swimming swimming) {
/*        Swimming swimming=new Swimming() {
            @Override
            public void swim() {
                System.out.println("一起游泳吧！");
            }
        }*/
        swimming.swim();
    }
}

