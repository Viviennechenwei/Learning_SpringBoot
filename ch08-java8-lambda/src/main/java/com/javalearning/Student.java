package com.javalearning;

import java.util.Optional;

public class Student {
    private String name;
    private int age;
    private char gender;
    private Integer classId;

    private Address address;

    //get 方法要用Optional的
    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Student(String name, int age, char gender, Integer classId, Address address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.classId = classId;
        this.address = address;
    }

    public Student(String name, int age, char gender, Integer classId) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.classId = classId;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", classId=" + classId +
                ", address=" + address +
                '}';
    }

    public Student() {
    }

}
