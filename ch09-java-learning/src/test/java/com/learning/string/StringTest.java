package com.learning.string;

import org.junit.Test;

public class StringTest {

    @Test
    public void stringTest() {

        String str1 = "ab" + "cd";
        String str11 = "abcd";
        System.out.println("str1 = str11 : " + (str1 == str11));
    }


    @Test
    public void create_string() {
        String s1 = "str"; //创建字符串方式一
        String s2 = "str";
        String s3 = new String("str"); //创建字符串方式二
        String s6 = new String("str");
        System.out.println(s1==s2);//true
        System.out.println(s1==s3);//false
        System.out.println(s3==s6);//false
        System.out.println(s1==s3.intern());//true

        String s4 = "test" + s1;
        String s5 = new StringBuilder("test").append(s1).toString();

        //String 的“+”，应尽量避免。会创建大量的String
        for (int i = 0; i < 10000; i++) {
            s1+="ing";  //反编译语句(new StringBuilder()).append(s1).append("ing").toString()
        }

        //应使用StringBuilder代替“+”
        StringBuilder sb = new StringBuilder("str");
        for (int i = 0; i < 10000; i++) {
            sb.append("ing");
        }
        sb.toString();


        String a1 = "happy" + "day"; //"happy" + "day"编译时候相当于"happyday"
        String a2 = "happyday";
        System.out.println(a1==a2); //true


        String a3 = "day";
        String a4 = "ha"+"ppy" + a3; //编译之后为"happy" + a3;
        System.out.println(a3==a2); //false
    }


}
