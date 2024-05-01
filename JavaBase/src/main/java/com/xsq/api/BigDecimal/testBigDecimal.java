package com.xsq.api.BigDecimal;

import java.math.BigDecimal;

public class testBigDecimal {
    public static void main(String[] args) {
        //BigDecimal、BigInteger支持任意精度
        BigDecimal bd1 = new BigDecimal(0.1);
        BigDecimal bd2 = new BigDecimal(0.2);
        System.out.println(bd1.add(bd2));
        System.out.println(0.1 + 0.2);
        double a = 0.1;
        double b = 0.2;
        System.out.println(a + b);//!!!
        System.out.println("-----------------------------------------------------");

        //如果想要进行精确的运算，就使用字符串的构造
        BigDecimal bd3 = new BigDecimal("0.1");
        BigDecimal bd4 = new BigDecimal("0.2");
        System.out.println("和为：" + bd3.add(bd4));

        System.out.println("差为：" + bd3.subtract(bd4));

        System.out.println("积为：" + bd3.multiply(bd4));

        System.out.println("商为：" + bd3.divide(bd4));
        System.out.println("---------------------------------------------------------");

        BigDecimal bd5 = new BigDecimal("10.0");
        BigDecimal bd6 = new BigDecimal("3.0");
        //System.out.println("商为："+bd5.divide(bd6));
        /*舍入模式：进一法：BigDecimal.ROUND_UP
                  去尾法：BigDecimal.ROUND_FLOOR
                  四舍五入：BigDecimal.ROUND_HALF_UP*/
        System.out.println(bd5.divide(bd6, 2, BigDecimal.ROUND_HALF_UP));
    }
}
