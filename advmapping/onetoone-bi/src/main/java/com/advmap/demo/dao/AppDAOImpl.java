package com.advmap.demo.dao;

import com.advmap.demo.entity.Instructor;
import com.advmap.demo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO {

    private final EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int Id) {
        return entityManager.find(Instructor.class, Id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {

        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailbyId(int id) {
        return entityManager.find(InstructorDetail.class,id );
    }

    @Override
    @Transactional
    public void deleteInstructorDetailbyId(int id) {
        InstructorDetail instructorDetail= entityManager.find(InstructorDetail.class,id);

        entityManager.remove(instructorDetail);
    }
}
