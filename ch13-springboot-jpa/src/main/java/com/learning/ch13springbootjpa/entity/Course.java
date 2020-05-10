package com.learning.ch13springbootjpa.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;
import java.util.Set;

//@Entity
//@Table(name="course")
public class Course {

    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

//    @OneToMany()
    private Set<Student> students;

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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
