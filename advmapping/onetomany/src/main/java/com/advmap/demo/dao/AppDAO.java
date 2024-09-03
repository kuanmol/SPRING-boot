package com.advmap.demo.dao;

import com.advmap.demo.entity.Course;
import com.advmap.demo.entity.Instructor;
import com.advmap.demo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int Id);

    void deleteById(int id);

    InstructorDetail findInstructorDetailbyId(int id);

    void deleteInstructorDetailbyId(int id);

    List<Course> findCoursesByInsturctorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);
    Course findCourseById(int id);
}
