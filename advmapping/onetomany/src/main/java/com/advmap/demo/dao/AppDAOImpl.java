package com.advmap.demo.dao;

import com.advmap.demo.entity.Course;
import com.advmap.demo.entity.Instructor;
import com.advmap.demo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

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
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailbyId(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInsturctorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", id);

        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> typedQuery = entityManager.createQuery("select i from Instructor i " +
                "JOIN FETCH i.courses " + "where i.id = :data", Instructor.class);

        typedQuery.setParameter("data", id);
        Instructor instructor = typedQuery.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }
}