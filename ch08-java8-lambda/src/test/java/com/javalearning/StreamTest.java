package com.javalearning;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void studentFilterStreamTest() {

        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student("Vivi", 17, 'F', 1);
        Student student2 = new Student("Sam", 20, 'M', 2);
        Student student3 = new Student("Xiaoming", 25, 'M', 2);
        Student student4 = new Student("Zhangsan", 32, 'F', 1);
        Student student5 = new Student("Zhangsi", 30, 'M', 2);
        Student student6 = new Student("Cuihua", 38, 'F', 1);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);


//        for (Student student : studentList) {
//            System.out.println(student.toString());
//        }

        //找出所有大于18岁的女性，姓名大写输出
        List<String> fn = studentList.stream()
                .filter(s -> s.getAge() > 10)
                .filter(s -> 'F' == s.getGender())
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        for (String s : fn) {
            System.out.println(s);
        }


        //
        Map<Integer, List<Student>> cl = studentList.stream()
                .collect(Collectors.groupingBy(s->s.getClassId()));

        for (Student s : cl.get(2)) {
            System.out.println(s);
        }
    }


}
