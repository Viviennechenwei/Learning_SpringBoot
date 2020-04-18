package com.javalearning;

import java.util.function.Function;

public class Client {

    public static void main(String[] args) {
        Function<Integer, Integer> ti = a -> a + 1;
        System.out.println(ti.apply(2));
    }
}

