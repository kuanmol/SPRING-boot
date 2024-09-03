package com.advmap.demo;

import com.advmap.demo.dao.AppDAO;
import com.advmap.demo.entity.Course;
import com.advmap.demo.entity.Instructor;
import com.advmap.demo.entity.InstructorDetail;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            //createInstructor(appDAO);
            //findInstructor(appDAO);
            //deleteInstuctor(appDAO);
            //findInstructorDetail(appDAO);
            //deleteInstuctorDetail(appDAO);
            //createInstructorWithCourses(appDAO);
            //findInstructorwithCourses(appDAO);
            //findCourseForInstructor(appDAO);
            //findInstructorwithCoursesJoinFetch(appDAO);
            //updateInstructor(appDAO);
            //updateCourse(appDAO);
            
        };
    }

    private void updateCourse(AppDAO appDAO) {
        int id = 10;
        System.out.println("FIndign the course id " + id);
        Course course = appDAO.findCourseById(id);
        System.out.println("updating the course id: " + id);
        course.setTitle("leg spin");
        appDAO.update(course);
    }

    private void updateInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("finding the instructor " + id);
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("updating the instructor id: " + id);
        instructor.setLastName("Tester");

        appDAO.update(instructor);
    }

    private void findInstructorwithCoursesJoinFetch(AppDAO appDAO) {
        int id = 1;
        System.out.println("finding instructor id " + id);
        Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
        System.out.println("Instructor is :" + instructor);
        System.out.println("The Associated courses are " + instructor.getCourses());

    }

    private void findCourseForInstructor(AppDAO appDAO) {

        int id = 1;
        System.out.println("Finding instructor id " + id);
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println(instructor);
        System.out.println("Finding courses for instructor of id " + id);
        List<Course> courses = appDAO.findCoursesByInsturctorId(id);
        instructor.setCourses(courses);
        System.out.println("courses given with him " + instructor.getCourses());
    }

    private void findInstructorwithCourses(AppDAO appDAO) {
        int id = 1;
        System.out.println("find the instructor id " + id);
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println(instructor);
        System.out.println(instructor.getCourses());
    }

    private void createInstructorWithCourses(AppDAO appDAO) {

        Instructor instructor = new Instructor("narendra", "modi", "marendra@gmail.com");

        InstructorDetail instructorDetail = new InstructorDetail("google.com",
                "throwing stones");

        instructor.setInstructorDetail(instructorDetail);

        Course course = new Course("inswing bowling");
        Course course1 = new Course("reverse bowling");
        Course course2 = new Course("outswing bowling");

        instructor.add(course);
        instructor.add(course1);
        instructor.add(course2);

        System.out.println(instructor);
        System.out.println(instructor.getCourses());
        appDAO.save(instructor);
    }

    private void deleteInstuctorDetail(AppDAO appDAO) {
        int id = 1;
        appDAO.deleteInstructorDetailbyId(id);

    }

    private void findInstructorDetail(AppDAO appDAO) {
        int id = 1;
        InstructorDetail instructorDetail = appDAO.findInstructorDetailbyId(id);
        System.out.println(instructorDetail);
        System.out.println(instructorDetail.getInstructor());
    }

    private void deleteInstuctor(AppDAO appDAO) {
        int id = 2;
        System.out.println("Instuctor that being delete " + id);
        appDAO.deleteById(id);
        System.out.println("Done");
    }

    private void findInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("FInd the instructor id : " + id);
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("instructor " + instructor);
        System.out.println("associated instructor detail only " + instructor.getInstructorDetail());

    }

    private void createInstructor(AppDAO appDAO) {

//        Instructor instructor = new Instructor("anmol", "kumar", "anmol@gmail.com");
//        InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/@CarryMinati",
//                "runing here and there");

        Instructor instructor = new Instructor("pokemon", "dallal", "pikachu@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("mujhe  ni chlana hutt",
                "throwing stones");

        instructor.setInstructorDetail(instructorDetail);
        System.out.println("saving instructions" + instructor);
        appDAO.save(instructor);

        System.out.println("DONE");
    }
}
