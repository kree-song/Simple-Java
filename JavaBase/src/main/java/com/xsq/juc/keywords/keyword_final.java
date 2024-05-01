package com.xsq.juc.keywords;

import java.util.Random;

public class keyword_final {
    static Random r = new Random();
    static final int k2 = r.nextInt(10);
    final int k1 = r.nextInt(10);

    public static void main(String[] args) {
        test1();
    }

    /**
     * static关键字所修饰的字段并不属于一个对象，而是属于这个类的
     */
    public static void test1() {
        keyword_final t1 = new keyword_final();
        System.out.println("k1=" + t1.k1 + " k2=" + t1.k2);//k1=7 k2=8
        keyword_final t2 = new keyword_final();
        System.out.println("k1=" + t2.k1 + " k2=" + t2.k2);//k1=3 k2=8
    }
}
