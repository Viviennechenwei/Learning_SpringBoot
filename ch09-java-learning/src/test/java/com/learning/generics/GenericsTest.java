package com.learning.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericsTest {

    @Test
    public void test(){
//        List list = new ArrayList();
//        list.add("string");
//        list.add(100);

//        for (int i = 0; i < list.size(); i++) {
//            String item = (String) list.get(i);
//            System.out.println("item is : " + item);
//        }

        List<String> list1 = new ArrayList<>();
        list1.add("String");
    }

    @Test
    public void test1(){
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        System.out.println(stringList.getClass()); //class java.util.ArrayList
        System.out.println(integerList.getClass()); // class java.util.ArrayList

        System.out.println(stringList.getClass().equals(integerList.getClass())); //true
    }

    @Test
    public void test2(){
        Generics<Integer> integerGenerics = new Generics<>(123);
        System.out.println(integerGenerics.getKey()); //123
        System.out.println(integerGenerics.getKey().getClass().getName()); //java.lang.Integer

        Generics<String> stringGenerics = new Generics<String>("string");
        System.out.println(stringGenerics.getKey().getClass().getName());

        Generics any = new Generics<>(123);
        System.out.println(any.getKey());
        System.out.println(any.getKey().getClass().getName()); //java.lang.Integer


        List<Integer> intList = new ArrayList<>();
//        List<Number> numberList = intList; //编译报错
    }



    public void TestGeneric(Generics<?> obj){
        System.out.println("generics test " + obj.getKey());
    }

    @Test
    public void test3(){
        Generics<Integer> gi = new Generics<>(123);
        Generics<Number> gn = new Generics<>(123);
        TestGeneric(gi);
        //TestGeneric (com.learning.generics.Generics<java.lang.Number>)
        //in GenericsTest cannot be applied to (com.learning.generics.Generics<java.lang.Integer>)
    }

    //声明一个泛型方法，该泛型方法中带一个T类型形参
    public <T> void formArrayToCollention(T[] obj, Collection<T> col){
        for(T o:obj){
            col.add(o);
            System.out.println("adding: " + o);
        }
    }

    @Test
    public void test4(){
        String[] strArr = {"a", "b"};
        Collection<String> strList = new ArrayList<>();
        formArrayToCollention(strArr,strList); //T代表String类型

        Integer[] intArr = {1, 2};
        Collection<Number> numList = new ArrayList<>();
        formArrayToCollention(intArr,numList); //T代表Number类型

    }



}
