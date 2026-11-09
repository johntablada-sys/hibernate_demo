package com.hibernate_demo.demo.dao;

import com.hibernate_demo.demo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDaoImplement implements StudentDao {

    // define field for entity manager
    private EntityManager em;

    // inject entity manager using constructor injection
    public StudentDaoImplement(EntityManager em) {
        this.em = em;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        em.persist(theStudent);
    }
}
