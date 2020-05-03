package com.learning.AutoboxingAndUnboxing;

import org.junit.Test;

import java.util.List;

public class IntegerAndintTest {

    @Test
    public void test() {
        int i1 = 128;
        Integer i2 = 128;
        Integer i3 = new Integer(128);
        System.out.println(i1 == i2);
        System.out.println(i1 == i3);

    }

    @Test
    public void test2() {
        boolean bo;
        char ch;
        byte by;
        short sh;
        int in;
        long lo;
        float fl;
        double dou;

        System.out.println("Byte min: " + Byte.MIN_VALUE + " max:" + +Byte.MAX_VALUE);
        System.out.println("Character min: " + Character.MIN_VALUE + " max:" + +Character.MAX_VALUE);
        System.out.println("Short min: " + Short.MIN_VALUE + " max:" + +Short.MAX_VALUE);
        System.out.println("Integer min: " + Integer.MIN_VALUE + " max:" + Integer.MAX_VALUE);
        System.out.println("Long min: " + Long.MIN_VALUE + " max:" + Long.MAX_VALUE);
        System.out.println("Float min: " + Float.MIN_VALUE + " max:" + Float.MAX_VALUE);
        System.out.println("Double min: " + Double.MIN_VALUE + " max:" + Double.MAX_VALUE);

        double d1 = 100.00;

        Double D1 = new Double(d1);

        int i1 = D1.intValue();
        System.out.println(d1);
        System.out.println(i1);
//        例如，字符中"32.1"转换double型的值的格式为:new Float("32.1").doubleValue()。也可以用:Double.valueOf("32.1").doubleValue()
        String s = "32.1";
        double d = new Double(s).doubleValue();
        double dd = Double.valueOf(s).doubleValue();
        System.out.println(d);
        System.out.println(dd);


        byte b = Byte.parseByte(s);

        short t = Short.parseShort(s);

    }

    @Test
    public void testInt() {
//        Integer i5 = 127;// java在编译的时候,被翻译成-> Integer i5 = Integer.valueOf(127);
        Integer i5 = Integer.valueOf(127);
        Integer i6 = 127;
        System.out.println(i5 == i6);// true
        Integer _i5 = 128;
        Integer _i6 = 128;
        System.out.println(_i5 == _i6);//false
        Integer ii5 = new Integer(127);
        System.out.println(i5 == ii5); // false
        Integer i7 = new Integer(128);
        Integer i8 = new Integer(128);
        System.out.println(i7 == i8); // false

    }
}
