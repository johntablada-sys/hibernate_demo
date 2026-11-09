package com.hibernate_demo.demo.dao;

import com.hibernate_demo.demo.entity.Student;

public interface StudentDao {

    void save(Student student);

    Student findById(Integer id);
}
