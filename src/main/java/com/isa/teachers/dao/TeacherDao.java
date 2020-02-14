package com.isa.teachers.dao;

import com.isa.teachers.entity.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class TeacherDao {
    Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Teacher teacher) {
        if (findById(teacher.getId()) == null) {
            entityManager.persist(teacher);
        }
    }

    public Teacher findById(Long id) {
        return (Teacher) entityManager.createNamedQuery("Teacher.findByID").getSingleResult();
    }

}
