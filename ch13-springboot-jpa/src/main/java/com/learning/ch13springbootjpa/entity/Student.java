package com.learning.ch13springbootjpa.entity;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    //注解写在属性或者getter方法上是一样的效果
    @ManyToOne(targetEntity = Clazz.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER) //CascadeType.ALL表示级练操作
    @JoinColumn(name = "clazz_id", referencedColumnName = "id") //表示对应子表的关联外键，如果不使用这个注解则需要创建中间表然后用@JoinTable
    private Clazz clazz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}
