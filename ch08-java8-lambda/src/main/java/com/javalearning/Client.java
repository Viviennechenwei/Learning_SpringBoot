package com.javalearning;

public class Client {

    public static void main(String[] args) {
        TestInterface ti = a -> {return a + 1;};
        System.out.println(ti.add(2));
    }
}

