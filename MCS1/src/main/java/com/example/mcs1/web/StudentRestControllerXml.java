package com.example.mcs1.web;

import com.example.mcs1.Entities.Student;
import com.example.mcs1.Repos.StudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = "application/xml")
public class StudentRestControllerXml {
    private StudentRepo studentRepo;
    public StudentRestControllerXml(StudentRepo studentRepo){
        this.studentRepo=studentRepo;
    }
    @GetMapping("/studentsXml")
    public List<Student> studentList(){
        return studentRepo.findAll();
    }
    @GetMapping("/studentsXml/{id}")
    public Student student(@PathVariable Long id){
        return studentRepo.findById(id).orElseThrow(() ->new
                RuntimeException(String.format("le compte %s n'existe pas !",id)));
    }
    @PostMapping("/studentsXml/{id}")
    public Student saveStudent(@RequestBody Student student){
        return studentRepo.save(student);
    }
    @PutMapping("/studentXml/{id}")
    public Student updateStudent(@PathVariable Long id,@RequestBody Student student){
        Student studentById=studentRepo.findById(id).get();
        if(student.getFullName() != null) studentById.setFullName(student.getFullName());
        if (student.getAddress()!=null) studentById.setAddress(student.getAddress());
        if (student.getGender()!=null) studentById.setGender(student.getGender());
        if (student.getEnabled()!=null) studentById.setEnabled(student.getEnabled());
        if (student.getNID()!=null) studentById.setNID(student.getNID());
        if (student.getBirthDate()!=null) studentById.setBirthDate(student.getBirthDate());
        if (student.getContactNo()!=null) studentById.setContactNo(student.getContactNo());
        return studentRepo.save(studentById);

    }
    @DeleteMapping("/studentsXml/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentRepo.deleteById(id);
    }
}

