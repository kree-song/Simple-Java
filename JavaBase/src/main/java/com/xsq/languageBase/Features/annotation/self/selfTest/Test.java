package com.xsq.languageBase.Features.annotation.self.selfTest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//表示Test这个注解的存活时间
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Test {
}