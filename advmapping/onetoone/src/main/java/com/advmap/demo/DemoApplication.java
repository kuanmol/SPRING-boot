package com.advmap.demo;

import com.advmap.demo.dao.AppDAO;
import com.advmap.demo.entity.Instructor;
import com.advmap.demo.entity.InstructorDetail;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            //createInstructor(appDAO);

            findInstructor(appDAO);

            //deleteInstuctor(appDAO);
        };
    }

    private void deleteInstuctor(AppDAO appDAO) {
        int id=2;
        System.out.println("Instuctor that being delete "+id);
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
