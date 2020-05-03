package com.learning.reflect;

public class Person {

    private String name;
    private int age;

    private void play(String city){
        System.out.println("playing in " + city);
    }
    public Person(String name, int age) {
        System.out.println("调用了Person的有参构造器， 参数为String name, int age");
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        System.out.println("调用了Person的有参构造器， 参数为String name");
        this.name = name;
    }

    private Person(int age) {
        System.out.println("调用了Person的有参构造器， 参数为int age");
        this.age = age;
    }

    public Person() {
        System.out.println("调用了Person的无参构造器");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
