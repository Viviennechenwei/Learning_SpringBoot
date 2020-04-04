package com.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties： 告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定；
 *     prefix = "person"： 配置文件中哪个下面的所有属性进行一一映射
 * @Component： 只有这个组件是容器中的bean是，才能有容器提供的@ConfigurationProperties功能
 */
@Component
@ConfigurationProperties(prefix = "person")
public class Person {

    private String lastName;
    private int age;
    private boolean boss;
    private Date birth;

    private Map<String, Object> myMaps;
    private List<Object> myLists;

    private Dog myDog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMyMaps() {
        return myMaps;
    }

    public void setMyMaps(Map<String, Object> myMaps) {
        this.myMaps = myMaps;
    }

    public List<Object> getMyLists() {
        return myLists;
    }

    public void setMyLists(List<Object> myLists) {
        this.myLists = myLists;
    }

    public Dog getMyDog() {
        return myDog;
    }

    public void setMyDog(Dog myDog) {
        this.myDog = myDog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", myMaps=" + myMaps +
                ", myLists=" + myLists +
                ", myDog=" + myDog +
                '}';
    }
}
