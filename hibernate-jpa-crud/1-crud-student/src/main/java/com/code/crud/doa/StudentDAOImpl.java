package com.code.crud.doa;

import com.code.crud.entity.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student thestudent) {
        entityManager.persist(thestudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student", Student.class);
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student delstudent = entityManager.find(Student.class, id);
        entityManager.remove(delstudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowDeleted=entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowDeleted;
    }
}
