package com.learning.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Period;

public class ReflectTest {

    /**
     * - Class.forName（）（常用）
     * - Person.class
     * - new Person().getClass()
     */
    @Test
    public void test_reflect() throws ClassNotFoundException {
        Object obj = Class.forName("com.learning.reflect.Person");
        Class obj2 = Person.class;
        Class obj3 = new Person().getClass();
        System.out.println(obj == obj2);//true
        System.out.println(obj == obj3);//true
    }

    /**
     * 1）获取类对象
     * 2）获取构造对象
     * 3）获取对象
     */
    @Test
    public void test_reflect_new_object_with_parameter() throws Exception {
        //1）获取类对象
        Class<?> pClass = Class.forName("com.learning.reflect.Person");
        //2）获取构造对象
        Constructor<?> con = pClass.getDeclaredConstructor(String.class);// 调用了Person的有参构造器， 参数为String name
        //3）获取对象'
        Person o = (Person) con.newInstance("Vivi");
        System.out.println(o.toString());//Person{name='Vivi', age=0}
    }

    @Test
    public void test_reflect_new_object_with_parameter_pravite() throws Exception {
        //1）获取类对象
        Class<?> pClass = Class.forName("com.learning.reflect.Person");
        //2）获取构造对象
        Constructor<?> con = pClass.getDeclaredConstructor(int.class);//调用了Person的有参构造器， 参数为int age
        //3）获取对象'
        con.setAccessible(true); //如果方法/属性是私有的，则需要设置Accessible为true
        Person o = (Person) con.newInstance(18);
        System.out.println(o.toString());//Person{name='null', age=18}
    }


    @Test
    public void test_reflect_new_object_no_parameter() throws Exception {
        //1）获取类对象
        Class<?> pClass = Class.forName("com.learning.reflect.Person");
        //2）获取构造对象
        Constructor<?> con = pClass.getDeclaredConstructor();//调用了Person的无参构造器
        //3）获取对象
        Person o = (Person) con.newInstance();
        System.out.println(o.toString());//Person{name='null', age=0}

        //与以下写法一样, 如果使用无参构造，则可省略2), 直接用类对象pClass.newInstance()
        Person person = (Person) pClass.newInstance();//调用了Person的无参构造器
        System.out.println(person.toString());//Person{name='null', age=0}
    }

    @Test
    public void test_reflect_set_private_field() throws Exception {
        //获得类对象
       Class pClass =  Class.forName("com.learning.reflect.Person");
        //通过无参构造器获得对象
        Person person = (Person)pClass.newInstance();//调用了Person的无参构造器
        //得到属性
       Field pName = pClass.getDeclaredField("name");
       //私有属性，需要设置Accessible为true
       pName.setAccessible(true);
        //设置属性
       pName.set(person, "Vivi");
        System.out.println(person);//Person{name='Vivi', age=0}
    }

    @Test
    public void test_reflect_set_private_method() throws Exception {
        //获得类对象
        Class pClass =  Class.forName("com.learning.reflect.Person");
        //通过无参构造器获得对象
        Person person = (Person)pClass.newInstance();//调用了Person的无参构造器
        //得到方法
        Method pMethod = pClass.getDeclaredMethod("play",java.lang.String.class);
        //私有方法，需要设置Accessible为true
        pMethod.setAccessible(true);
        //方法调用
        pMethod.invoke(person, "Shanghai");//playing in Shanghai
    }
}
