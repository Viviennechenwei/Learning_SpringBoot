package com.learning.ch13springbootjpa.service;

import com.learning.ch13springbootjpa.entity.Clazz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ClazzService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Clazz getClazz(Integer id) {
        Clazz clazz = entityManager.find(Clazz.class, id);
        System.out.println("get clazz");
        System.out.println("clazz " + clazz.getStudents().size());
        return clazz;
    }

    @Transactional
    public Clazz createClazz(Clazz clazz) {
        entityManager.persist(clazz);
        return clazz;
    }
}
