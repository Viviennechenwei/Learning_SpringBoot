package com.javalearning;

import org.junit.Test;

import java.util.function.Function;

public class ArrayReferenceTest {

    @Test
    public void array_referenct_test(){
        Function<Integer,String[]> function = x->new String[x];
        String[] strings = function.apply(10);
        System.out.println(strings.length);

        Function<Integer, String[]> function1 = String[]::new;
        String[] strings1 = function1.apply(12);
        System.out.println(strings1.length);
    }
}
