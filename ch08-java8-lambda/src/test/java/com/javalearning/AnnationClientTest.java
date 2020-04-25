package com.javalearning;

import org.junit.Test;

import java.lang.reflect.Field;

public class AnnationClientTest {
    @Test
    public void testAnnation() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class studentClass = Class.forName("com.javalearning.School");
        Field[] snames = studentClass.getDeclaredFields();
        for (Field sn : snames) {
            if (sn.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annotation = sn.getAnnotation(MyAnnotation.class);
                if (annotation != null) {
                    System.out.println(annotation.name() + annotation.age() + annotation.favoriteFood());
                }
            }
        }
        System.out.println(studentClass);
    }
}
