package com.example.mcs1.service;

import com.example.mcs1.DTO.StudentDTORequest;
import com.example.mcs1.DTO.StudentDTOResponse;
import org.springframework.graphql.data.method.annotation.Argument;

public interface StudentService {
    StudentDTOResponse addStudent(StudentDTORequest studentDTORequest);
  StudentDTOResponse updateStudent(Long id,StudentDTORequest studentDTORequest);
  void deleteStudent(Long id);
   // public void run(String... args)throws Exception;
}
