package com.code.crud;

import com.code.crud.doa.StudentDAO;
import com.code.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //createStudent(studentDAO);
            createMultipleStudents(studentDAO);
            // readStudent(studentDAO);
            //  queryForStudents(studentDAO);
            // deleteStudent(studentDAO);
            //deleteAll(studentDAO);
        };
    }

    private void deleteAll(StudentDAO studentDAO) {
        System.out.println("Deleting all student");
        int numRow = studentDAO.deleteAll();
        System.out.println(numRow);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 5;
        System.out.println("deleting student id " + studentId);
        studentDAO.delete(studentId);
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();

        for (Student temp : students) {
            System.out.println(temp);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("creating student object");
        Student temp = new Student("Mickey", "Mouse", "clubhouse@gmail.com");

        System.out.println("saving the student");
        studentDAO.save(temp);

        int theID = temp.getId();
        System.out.println("saved student, Generated id: " + theID);

        System.out.println("Retreiving the student id: " + theID);
        Student mystudent = studentDAO.findById(theID);

        System.out.println("Found that student " + mystudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        System.out.println("------------Creating 3 student object-----------");
        Student students1 = new Student("Suresh", "Raina", "SureshRaina@gmail.com");
        Student students2 = new Student("Jitesh", "Sharma", "jitesh@gmail.com");
        Student students3 = new Student("Mandal", "Singh", "mandalsingh@gmail.com");

        System.out.println("saving the data");
        studentDAO.save(students1);
        studentDAO.save(students2);
        studentDAO.save(students3);

    }

    private void createStudent(StudentDAO studentDAO) {

        System.out.println("------------Creating new student object-----------");
        Student student = new Student("Anmol", "Kumar", "anmolkumar@gmail.com");

        System.out.println("saving the data of student _________________");
        studentDAO.save(student);

        System.out.println("Saved student. Generated ID:  " + student.getId());
    }
}
