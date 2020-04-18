package com.javalearning;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class FunctionalTest {

    String string;
    BiFunction f;
    //消费型函数接口测试
    @Test
    public void testConsumer(){
        age(18, a -> System.out.println("my age is: " + a));
    }

    public void age(int x, Consumer consumer){
        consumer.accept(x);
    }



    //供给型函数接口测试
    @Test
    public void testSupplier(){
        List<Double> list = supplierMethod(10, ()-> Math.random());
        for (Double i: list){
            System.out.println(i);
        }
    }

    //产生指定个数的整数并放入集合中
    public List<Double> supplierMethod(int num, Supplier<Double> supplier){
        List<Double> list = new ArrayList<>();
        for (int i=0; i<num; i++){
            list.add(supplier.get());
        }
        return list;
    }

    //函数型接口测试
    @Test
    public void testFunction(){
        String resStr = strHandler("\t \t Hello Function    ", str->str.trim());
        System.out.println(resStr);
    }

    public String strHandler(String s, Function<String, String> function){
        return function.apply(s);
    }

    //断言型接口测试
    @Test
    public void testPercidate(){
        List<Integer> numList = Arrays.asList(12,130,123,32,45,612,95,100,139);
        List<Integer> l = filterNum(numList,num->num>100);
        for(Integer i : l){
            System.out.println(i);
        }
    }

    public List<Integer> filterNum(List<Integer> numList, Predicate<Integer> predicate){
        List<Integer> resList = new ArrayList<>();
        for (Integer num : numList){
            if(predicate.test(num)){
                resList.add(num);
            }
        }
        return resList;
    }
}
