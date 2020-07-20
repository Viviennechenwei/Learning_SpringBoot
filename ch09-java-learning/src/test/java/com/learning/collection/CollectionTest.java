package com.learning.collection;

import org.junit.Test;

import java.sql.Connection;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class CollectionTest {

    @Test
    public void collectionForEach() {
        Collection<Integer> collection = Arrays.asList(1, 2, 3);

        //第二种遍历方式：collection继承自Iterable接口，可以使用Iterable中的forEach方法
        collection.forEach(System.out::println);

        //第二种遍历方式：使用for-each
        for (Integer i : collection) {
            System.out.println(i);
        }

        //第三种遍历方式：使用Iterator迭代器
        Iterator<Integer> it = collection.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }


    @Test
    public void MapTest() {
        Map<String, Integer> myMap = new HashMap();
        myMap.put("zhangsan", 18);
        myMap.put("lisi", 19);
        myMap.put("wangwu", 24);
        //方法一、entrySet()遍历map
        for (Map.Entry<String, Integer> m : myMap.entrySet()) {
            System.out.println("key: " + m.getKey() + " value: " + m.getValue());
        }
        //entrySet() java 8 写法
        myMap.entrySet().forEach(m-> System.out.println("key: " + m.getKey() + " value: " + m.getValue()));


        //方法二、keySet() 遍历map
        for (String k : myMap.keySet()) {
            System.out.println("key: " + k + " value: " + myMap.get(k));
        }

        //java 8 遍历map的key, value
        myMap.forEach((k, v) -> System.out.println("key: " + k + " value: " + v));
        //java 8 遍历map的value
        myMap.values().forEach(System.out::println);

        //方法三、只用迭代器
        Iterator<Map.Entry<String, Integer>> iterator = myMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("key: " + entry.getKey() + " value: " +entry.getValue());
        }
    }
}
