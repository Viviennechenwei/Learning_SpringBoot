package com.javalearning;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class MethodReferenceTest {

    //对象::实例方法名（非静态方法）
    @Test
    public void object_method_reference_Test() {
        PrintStream printStream = System.out; //PrintStream 对象
        Consumer cs1 = x -> printStream.println(x); //lambda表达式写法
        cs1.accept("test cs1");

        Consumer cs2 = printStream::println; //当lambda表达式时对象调用实例方法时可用方法引用（对象::实例方法名）
        cs2.accept("test cs2");

        Consumer cs3 = System.out::println; //合并写法
        cs3.accept("test cs3");
    }

    @Test
    public void class_reference_static_method() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        /**Compares its two arguments for order. Returns a negative integer,zero,
         or a positive integer as the first argument is less than, equal to, or greater than the second.
         **/
        int res = comparator.compare(3, 3);
        System.out.println(res);

        Comparator<Integer> comparator1 = Integer::compare;
        int res1 = comparator1.compare(10, 3);
        System.out.println(res1);
    }

    @Test
    public void class_reference_method(){
        BiPredicate<String, String> biPredicate = (x,y)->x.equals(y);
        System.out.println(biPredicate.test("abc", "abc"));

        BiPredicate<String, String> biPredicate1 = String::equals;
        System.out.println(biPredicate1.test("ert", "ert"));
    }
}
