package com.code.crud.doa;

import com.code.crud.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student thestudent);

    Student findById(Integer id);

    List<Student> findAll();

    void delete(Integer id);

    int deleteAll();
}
