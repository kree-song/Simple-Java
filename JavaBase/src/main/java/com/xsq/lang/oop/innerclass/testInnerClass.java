package com.xsq.lang.oop.innerclass;

/*
 * 内部类访问特点：1）内部类可以直接访问外部类的成员，包括私有
 *              2）外部类要访问内部类的成员，必须创建对象
 * 创建内部类的格式： 外部类名.内部类名 对象名=new 外部类对象.new 内部类对象
 * 分类：1）在类的成员位置：成员内部类
 *        private：只能在所在外部类使用
 *        static：静态成员内部类访问格式：外部类名.内部类名 对象名=new 外部类名.内部类名()
 *                访问静态方法：外部类名.内部类名.方法名()
 *      2）在类的局部位置：局部内部类(局部内部类是在方法中定义的类，所以外界是无法使用的，需要在方法内部创建对象并使用，
 *                             该类可以直接访问外部类的成员，也可以访问方法内的局部变量)
 * */
public class testInnerClass {
    public static void main(String[] args) {
        //创建内部类的格式： 外部类名.内部类名 对象名=new 外部类对象.new 内部类对象
        Outer.Inner i = new Outer().new Inner();
        System.out.println(i.num);
        i.show();

        System.out.println("-------------------------------");

        Outer02 outer02 = new Outer02();
        outer02.method();
    }
}

class Outer {
    private int a = 10;

    class Inner {
        int num = 100;

        public void show() {
            System.out.println("Inner..show");
            //内部类访问外部类成员可以直接访问，包括私有
            System.out.println(a);
        }
    }
}

//测试局部内部类
class Outer02 {
    int a = 10;

    public void method() {
        int b = 20;

        class Inner02 {
            public void show() {
                System.out.println("show..");
                System.out.println(a);
                System.out.println(b);
            }
        }

        Inner02 i = new Inner02();
        i.show();
    }
}