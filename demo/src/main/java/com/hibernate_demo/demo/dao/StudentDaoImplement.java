package com.hibernate_demo.demo.dao;

import com.hibernate_demo.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
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

    @Override
    public Student findById(Integer id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query =
                em.createQuery("FROM Student ORDER BY lastName", Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query =
                em.createQuery("FROM Student WHERE lastName=:data", Student.class);
        query.setParameter("data", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        em.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = em.find(Student.class, id);
        if (student != null) {
            em.remove(student);
        }
    }
}
