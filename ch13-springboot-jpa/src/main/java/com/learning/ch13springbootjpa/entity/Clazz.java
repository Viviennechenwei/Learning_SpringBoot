package com.learning.ch13springbootjpa.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clazz")
public class Clazz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(targetEntity = Student.class,fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "clazz_id", referencedColumnName = "id")
    private List<Student> students;

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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
