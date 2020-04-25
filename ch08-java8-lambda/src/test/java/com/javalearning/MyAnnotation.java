package com.javalearning;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
//元注解
public @interface MyAnnotation {
    //属性列表
    String name() ;
    int age() default 18;
    String[] favoriteFood();
}
