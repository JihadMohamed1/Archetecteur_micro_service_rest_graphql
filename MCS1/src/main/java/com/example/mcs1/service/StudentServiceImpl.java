package com.example.mcs1.service;

import com.example.mcs1.DTO.StudentDTORequest;
import com.example.mcs1.DTO.StudentDTOResponse;
import com.example.mcs1.Entities.Classroom;
import com.example.mcs1.Entities.Student;
import com.example.mcs1.Repos.ClassroomRepo;
import com.example.mcs1.Repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepo studentRepo;
    ClassroomRepo classroomRepo;
    @Override
    public StudentDTOResponse addStudent(StudentDTORequest studentDTORequest) {
        Student student=new Student();
        student.setFullName(studentDTORequest.getFullName());
        student.setGender(studentDTORequest.getGender());
        student.setAddress(studentDTORequest.getAdress());
        student.setNID(studentDTORequest.getNID());
        student.setContactNo(studentDTORequest.getContactNo());
        student.setBirthDate(new Date());
        student.setEnabled(Boolean.TRUE);
        student.setClassroom(studentDTORequest.getClassroom());
        Student saveStudent=studentRepo.save(student);
        StudentDTOResponse studentDTOResponse = new StudentDTOResponse();
        studentDTOResponse.setFullName(saveStudent.getFullName());
        studentDTOResponse.setNID(saveStudent.getNID());
        studentDTOResponse.setEnabled(saveStudent.getEnabled());
        studentDTOResponse.setAdress(saveStudent.getAddress());
        studentDTOResponse.setBirtDate(saveStudent.getBirthDate());
        studentDTOResponse.setContactNo(saveStudent.getContactNo());
        studentDTOResponse.setGender(saveStudent.getGender());
        studentDTOResponse.setClassroom(saveStudent.getClassroom());
        return studentDTOResponse;

    }

    @Override
    public StudentDTOResponse updateStudent(Long id, StudentDTORequest studentDTORequest) {
        Student student = studentRepo.findById(id).orElseThrow(()->new RuntimeException("student not found !"));
        student.setFullName(studentDTORequest.getFullName());
        student.setGender(studentDTORequest.getGender());
        student.setAddress(studentDTORequest.getAdress());
        student.setNID(studentDTORequest.getNID());
        student.setContactNo(studentDTORequest.getContactNo());
        student.setFullName(studentDTORequest.getFullName());
        student.setGender(studentDTORequest.getGender());
        student.setAddress(studentDTORequest.getAdress());
        student.setNID(studentDTORequest.getNID());
        student.setContactNo(studentDTORequest.getContactNo());
        student.setBirthDate(studentDTORequest.getBirtDate());
        student.setClassroom(studentDTORequest.getClassroom());
        StudentDTOResponse studentDTOResponse = new StudentDTOResponse();
        studentDTOResponse.setFullName(student.getFullName());
        studentDTOResponse.setNID(student.getNID());
        studentDTOResponse.setEnabled(student.getEnabled());
        studentDTOResponse.setAdress(student.getAddress());
        studentDTOResponse.setBirtDate(student.getBirthDate());
        studentDTOResponse.setContactNo(student.getContactNo());
        studentDTOResponse.setGender(student.getGender());
    Classroom classe = classroomRepo.findByName(String.valueOf(student.getClassroom()));
        studentDTOResponse.setClassroom(classe);
        return studentDTOResponse;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }


}
