package com.xsq.lang.features.annotation.elemAnno;

public class testStudent {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取到Student类的字节码文件对象
        Class clazz = Class.forName("com.xsq.lang.features.annotation.elemAnno.Student");

        //获取注解
        boolean result = clazz.isAnnotationPresent(Anno.class);
        System.out.println(result);
    }
}