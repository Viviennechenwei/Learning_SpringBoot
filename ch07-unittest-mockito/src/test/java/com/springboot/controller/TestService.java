package com.springboot.controller;

public class TestService {

    public String m1(){
        System.out.println("invoke TestService m1 method...");
        return "RealM1";
    }

    public String m2(){
        System.out.println("invoke TestService m2 method...");
        return "RealM2";
    }
}
