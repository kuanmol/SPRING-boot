package com.advmap.demo.dao;

import com.advmap.demo.entity.Instructor;
import com.advmap.demo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int Id);

    void deleteById(int id);

    InstructorDetail findInstructorDetailbyId(int id);

    void deleteInstructorDetailbyId(int id);
}
