package com.xsq.api.Math;

public class testMath {
    public static void main(String[] args) {
        System.out.println(Math.abs(-10) + "\n" +
                Math.ceil(10.1) + "\n" +
                Math.floor(10.1) + "\n" +
                Math.round(4.4) + "\n" +
                Math.max(5.1, 9.2) + "\n" +
                Math.min(5.1, 9.2) + "\n" +
                Math.pow(2, 3) + "\n" +
                //返回[0.0,1.0)之间的随机数
                Math.random() + "\n" +
                Math.sqrt(144) + "\n" +
                Math.log(Math.E) + "\n" +
                Math.log10(100) + "\n" +
                Math.sin(Math.PI / 6) + "\n" +
                Math.cos(Math.PI / 3));
    }
}
