package com.learning.ch13springbootjpa.entity;

import com.learning.ch13springbootjpa.service.ClazzService;
import com.learning.ch13springbootjpa.service.StudentService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.PersistenceContext;
import java.util.Arrays;

@SpringBootTest
public class StudentTest {

    @Autowired
    ClazzService clazzService;

    @Autowired
    StudentService studentService;

    @Test
    public void getClassStudent() {
        Assert.assertNotNull(clazzService.getClazz(5));
    }

    @Test
    public void createClassStudent() {
        Clazz clazz = new Clazz();
        clazz.setName("clazz 3");
        Student stu1 = new Student();
        stu1.setName("stu1");
        Student stu2 = new Student();
        stu2.setName("stu2");
        clazz.setStudents(Arrays.asList(stu1, stu2));
        Clazz returned = clazzService.createClazz(clazz);
        Assert.assertEquals(clazz, returned);
        Assert.assertNotNull(clazz.getId());
    }



    @Test
    public void getStudentById(){
        Assert.assertNotNull(studentService.getStudentById(3));
    }

    @Test
    public void getStudents(){
        Assert.assertNotNull(studentService.getAllStudents());
    }

}
