package com.example.mcs1;

import com.example.mcs1.Entities.Classroom;
import com.example.mcs1.Entities.Student;
import com.example.mcs1.Enums.Gender;
import com.example.mcs1.Repos.ClassroomRepo;
import com.example.mcs1.Repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Mcs1Application implements CommandLineRunner {
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ClassroomRepo classroomRepo;
    public static void main(String[] args) { SpringApplication.run(Mcs1Application.class, args); }
    @Override
    public void run(String... args) throws  Exception{
        for(long i=1; i<=10; i++){
           Classroom classroom= Classroom.builder()
                   .id(i)
                   .name("classe"+i)
                   .build();
           classroomRepo.save(classroom);
        }
        classroomRepo.findAll().forEach(classroom -> {
            for(int i=1;i<=10;i++){
                studentRepo.save(new Student(i,"etud"+i,new Date(),"CIN"+i,
                        (i%2 == 0)?Gender.FEMALE:Gender.MALE,"0661000"+i,
                        "address Etudiant"+i,(i%2 ==0)?Boolean.FALSE:Boolean.TRUE,
                        classroom));
                //hello
            }
        });
    }

}
