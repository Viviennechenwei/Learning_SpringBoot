package com.javalearning;

import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLearning {

    static List<Student> studentList = Arrays.asList(
            new Student("Vivi", 17, 'F', 1),
            new Student("Sam", 20, 'M', 2),
            new Student("Xiaoming", 25, 'M', 2),
            new Student("Zhangsan", 32, 'F', 1),
            new Student("Zhangsan", 32, 'F', 2),
            new Student("Zhangsi", 30, 'M', 2),
            new Student("Cuihua", 38, 'F', 1));


    //创建Stream
    @Test
    public void create_stream_test() {
        //Collection系列集合提供的stream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //Arrays中静态放他stream(),获取数组流
        String[] strings = new String[]{"ab", "cd"};
        Stream<String> stream1 = Arrays.stream(strings);
    }

    @Test
    public void stream_middle_handle_test() {

        //中间操作，不会执行任何操作
        Stream<Student> studentStream = studentList.stream()
                .filter(s -> {
                    System.out.println("Stream API的中间操作");
                    return s.getAge() > 20;
                })
                .skip(2);
        //终止操作，一次性执行全部内容，即“惰性求值”
        studentStream.forEach(System.out::println);

        System.out.println("----------map, sorted---------");
        studentList.stream()
                .filter(s -> s.getGender() == 'F')
                //.map(s -> s.getAddressName()) //接收Student的Stream<Student>，返回student的name 的Stream<String>
                .map(Student::getName)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println("----------定制排序---------");
        studentList.stream()
                //.sorted((s1,s2)->Integer.compare(s1.getAge(),s2.getAge())) 定制排序，跟下面的写法一样
                .sorted(Comparator.comparingInt(Student::getAge))
                .forEach(System.out::println);

    }

    @Test
    public void stream_reduce_test() {
        List<Integer> list = Arrays.asList(1, 2, 20, 3, 4, 5, 6, 7, 8, 9, 10);
        //reduce 用来求和
        Integer sum = list.stream()
                //.reduce(0, (x, y) -> x + y)
                .reduce(0, Integer::sum);
        System.out.println(sum);


        //reduce用来找最大年龄值，java8返回Optional，用于避免空指针异常
        Optional<Integer> age = studentList.stream()
                .map(student -> student.getAge())
                .reduce(Integer::max);
        System.out.println(age.get());

        //用max()也可得到最大年龄值
        Optional<Integer> age2 = studentList.stream()
                .map(student -> student.getAge())
                .max(Integer::compareTo);
        System.out.println(age2.get());

    }

    @Test
    public void stream_reduce_collector() {
        //Collectors 转为list
        List<String> names = studentList.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(names); //[Vivi, Sam, Xiaoming, Zhangsan, Zhangsan, Zhangsi, Cuihua]

        //Collectors 分组, 一级和多级分组都支持
        Map<Integer, Map<Object, List<Student>>> collect = studentList.stream()
                .collect(Collectors.groupingBy(Student::getClassId, Collectors.groupingBy(s -> {
                    if (s.getAge() < 30) {
                        return "青年";
                    } else {
                        return "中年";
                    }

                })));
        //{1={青年=[Student{name='Vivi', age=17, gender=F, classId=1}], 中年=[Student{name='Zhangsan', age=32, gender=F, classId=1}, Student{name='Cuihua', age=38, gender=F, classId=1}]}, 2={青年=[Student{name='Sam', age=20, gender=M, classId=2}, Student{name='Xiaoming', age=25, gender=M, classId=2}], 中年=[Student{name='Zhangsan', age=32, gender=F, classId=2}, Student{name='Zhangsi', age=30, gender=M, classId=2}]}}
        System.out.println(collect);

        //Collectors 字符连接
        String collect1 = studentList.stream()
                .map(Student::getName)
                .collect(Collectors.joining(",", "prefix = ", "= suffix"));
        //prefix = Vivi,Sam,Xiaoming,Zhangsan,Zhangsan,Zhangsi,Cuihua= suffix
        System.out.println(collect1);

        ////Collectors IntSummaryStatistics(A state object for collecting statistics such as count, min, max, sum, and average.)
        IntSummaryStatistics collect2 = studentList.stream()
                .collect(Collectors.summarizingInt(Student::getAge));
        System.out.println(collect2.getAverage());
        System.out.println(collect2.getCount());
        System.out.println(collect2.getMax());
        System.out.println(collect2.getSum());

        //Collectors 分区
        Map<Boolean, List<Student>> collect3 = studentList.stream()
                .collect(Collectors.partitioningBy(s -> s.getAge() > 20));
        //{false=[Student{name='Vivi', age=17, gender=F, classId=1}, Student{name='Sam', age=20, gender=M, classId=2}], true=[Student{name='Xiaoming', age=25, gender=M, classId=2}, Student{name='Zhangsan', age=32, gender=F, classId=1}, Student{name='Zhangsan', age=32, gender=F, classId=2}, Student{name='Zhangsi', age=30, gender=M, classId=2}, Student{name='Cuihua', age=38, gender=F, classId=1}]}
        System.out.println(collect3);
    }


}
