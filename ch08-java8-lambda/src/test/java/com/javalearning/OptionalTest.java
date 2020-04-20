package com.javalearning;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void optional_test() {
        Optional optional = Optional.of(new Student()); //创建一个非空Optional实例
        System.out.println(optional.isPresent());//true 判断optional是否有值
        System.out.println(optional.get());//Student{name='null', age=0, gender= , classId=null} 拿出值

        Optional optional1 = Optional.empty();//创建空的Optional实例
        if (optional1.isPresent()) { //false
            System.out.println(optional1.get());
        }

        //ofNullable(T value)：value == null ? empty() : of(value); 若value为null，则创建空的Optional，否则创建value实例
        Optional<Student> optional2 = Optional.ofNullable(null);
        System.out.println(optional2.isPresent());//false

        //public T orElse(T other) { return value != null ? value : other; }
        Student s = optional2.orElse(new Student("Vivi", 18, 'F', 1));
        System.out.println(s); //Student{name='Vivi', age=18, gender=F, classId=1}

        Student s1 = optional2.orElseGet(() -> new Student());
        System.out.println(s1); //Student{name='null', age=0, gender= , classId=null}

        //public<U> Optional<U> map(Function<? super T, ? extends U> mapper)
        Optional<Student> o3 = Optional.ofNullable(new Student("Vivi", 18, 'F', 1));
        Optional<String> s2 = o3.map(student -> s.getName());
        if (s2.isPresent()) {
            System.out.println(s2.get());//Vivi
        }

        //public<U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper)， flatMap与map的差别在于第二个参数要用Optional的
        Optional<String> s3 = o3.flatMap(student -> Optional.of(student.getName()));
        if (s3.isPresent()) {
            System.out.println(s2.get());//Vivi
        }
    }


//    @Test
//    public void optional_apply_test() {
//        String countryName = null;
//        Student student = new Student("Vivi", 18, 'F', 1, new Address(new Country("Henan")));
//        if (student != null) {
//            if (student.getAddress() != null) {
//                if(student.getAddress().getCountry()!=null){
//                    countryName = student.getAddress().getCountry().getCountryName();
//                }
//            }
//        }
//
//        System.out.println(countryName); //Vivi's dog
//    }

    @Test
    public void optional_replace_null_test(){
        Student student = new Student("Vivi", 18, 'F', 1, new Address(new Country("Henan")));
        String cn = Optional.ofNullable(student)
                .flatMap(s -> s.getAddress())
                .flatMap(a -> a.getCountry())
                .map(c->c.getCountryName())
                .orElse("default");
        System.out.println(cn);
    }


    @Test
    public void optional_replace_null_short_test(){
        Student student = new Student("Vivi", 18, 'F', 1, new Address(new Country("Henan")));
        String cn = Optional.ofNullable(student)
                .flatMap(Student::getAddress)
                .flatMap(Address::getCountry)
                .map(Country::getCountryName)
                .map(String::toUpperCase)
                .orElse("default");
        System.out.println(cn);
    }

    @Test
    public void optional_string_test(){
        String s = null;
        System.out.println(string1_test(s));
        System.out.println(string2_test(s));
    }

    public int string1_test(String s){
        if(s==null){
            return 0;
        }
        return s.length();
    }


    public int string2_test(String s){
        return Optional.ofNullable(s).map(String::length).orElse(0);
    }




}
