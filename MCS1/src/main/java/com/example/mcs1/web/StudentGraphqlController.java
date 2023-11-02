package com.example.mcs1.web;

import com.example.mcs1.DTO.StudentDTORequest;
import com.example.mcs1.DTO.StudentDTOResponse;
import com.example.mcs1.Entities.Classroom;
import com.example.mcs1.Entities.Student;
import com.example.mcs1.Repos.ClassroomRepo;
import com.example.mcs1.Repos.StudentRepo;
import com.example.mcs1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentGraphqlController {
    @Autowired
    private StudentRepo studentRepo;
    private ClassroomRepo classroomRepo;
    private StudentService studentService;
    @QueryMapping
    private List<Student> students(){
        return studentRepo.findAll();
    }
    @QueryMapping(name = "student")
    private Student studentById(@Argument Long id){
        return studentRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Student not found!"));
    }
    @MutationMapping
    private StudentDTOResponse addStudent(@Argument StudentDTORequest studentDTORequest){
        return studentService.addStudent(studentDTORequest);
    }
    @MutationMapping
    private StudentDTOResponse updateStudent(@Argument Long id,@Argument StudentDTORequest studentDTORequest){
        return studentService.addStudent(studentDTORequest);
    }
    @MutationMapping
    private void deleteStudent(@Argument Long id){
        studentService.deleteStudent(id);
    }
    @QueryMapping
    private List<Classroom> classrooms(){
        return classroomRepo.findAll();
    }

}
