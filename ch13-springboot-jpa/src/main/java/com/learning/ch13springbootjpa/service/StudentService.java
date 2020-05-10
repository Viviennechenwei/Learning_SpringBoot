package com.learning.ch13springbootjpa.service;

import com.learning.ch13springbootjpa.entity.Clazz;
import com.learning.ch13springbootjpa.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class StudentService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Clazz getStudentById(Integer id){
        Student student = entityManager.find(Student.class, id);
        Clazz clazz = student.getClazz();
        System.out.println(clazz);
        return clazz;
    }

    @Transactional
    public List<Student> getAllStudents(){
        List<Student> students = entityManager.createQuery("SELECT s FROM Student s").getResultList();
        students.forEach(System.out::println);
        System.out.println(students.size());
        return students;
    }
}
