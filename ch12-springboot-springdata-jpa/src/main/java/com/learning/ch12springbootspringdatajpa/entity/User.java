package com.learning.ch12springbootspringdatajpa.entity;

import javax.persistence.*;

//使用JPA注解配置映射关系
@Entity //告诉JPA这是一个实体类（和数据库映射的类）
@Table(name = "user") //来指定和那个数据表对应；如果省略默认表明就是user
public class User {

    @Id //表明这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;

    @Column(name = "last_name", length = 50) //这是和数据表对应的一个列， 如果不设置name属性的值，默认为列名
    private String lastNme;

    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastNme() {
        return lastNme;
    }

    public void setLastNme(String lastNme) {
        this.lastNme = lastNme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
