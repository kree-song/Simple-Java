package com.xsq.languageBase.Features.annotation.elemAnno;

import java.lang.annotation.*;

/*
 * 元注解
 * */
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})  //指定注解使用的位置（成员变量，类，方法）
@Retention(RetentionPolicy.RUNTIME) //指定该注解的存活时间。不写则表示源码有效，编译后就无
@Inherited //指定该注解可以被继承
public @interface Anno {
}