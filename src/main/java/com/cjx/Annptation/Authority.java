package com.cjx.Annptation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})// 可用在方法名 类名上
@Retention(RetentionPolicy.RUNTIME)// 运行时有效
public @interface Authority {
    String[] roles();
}
