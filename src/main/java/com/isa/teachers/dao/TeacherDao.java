package com.isa.teachers.dao;

import com.isa.teachers.dto.TeacherNameDTO;
import com.isa.teachers.entity.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;


@Stateless
public class TeacherDao {
    Logger logger = LoggerFactory.getLogger(getClass().getName());

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Teacher teacher) {
        if (findById(teacher.getId()) == null) {
            entityManager.persist(teacher);
            logger.info("Teacher persisted: {}", (teacher.getFirstName() + " " + teacher.getLastName()));
            return;
        }
        logger.warn("Teacher already in database");
    }

    public Teacher find(Teacher teacher) {
        return Optional.ofNullable(entityManager.find(Teacher.class, teacher)).get();
    }

    public Teacher findById(Long id) {

        Query query = entityManager.createNamedQuery("Teacher.findById");
        query.setParameter("id", id);
        return (Teacher) query.getSingleResult();
    }

    public void remove(Teacher teacher) {
        logger.info("Deleting teacher {} from database", (teacher.getFirstName() + " " + teacher.getLastName()));
        entityManager.remove(teacher);
    }

    public Teacher update(Teacher teacher) {
        return entityManager.merge(teacher);
    }

    public List<Teacher> findAll() {
        Query query = entityManager.createNamedQuery("Teacher.findAll");
        return query.getResultList();
    }
}
