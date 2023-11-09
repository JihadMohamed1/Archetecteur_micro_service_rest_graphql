package com.example.mcs1.web;

import com.example.mcs1.Entities.Student;
import com.example.mcs1.Repos.StudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class StudentRestController {
    private StudentRepo studentRepo;
    public StudentRestController(StudentRepo studentRepo){
        this.studentRepo=studentRepo;
    }
    @GetMapping("/etds")
    public List<Student> studentList(){
        return studentRepo.findAll();
    }
    @GetMapping("/students/{id}")
        public Student student(@PathVariable Long id){
            return studentRepo.findById(id).orElseThrow(() ->new
                    RuntimeException(String.format("le compte %s n'existe pas !",id)));
        }
    @GetMapping("/Home")
    public String student(){
        return "<h1>hello mather fuker</h2>";
    }
        @PostMapping("/students/{id}")
    public Student saveStudent(@RequestBody Student student){
        return studentRepo.save(student);
        }
        @PutMapping("/student/{id}")
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
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentRepo.deleteById(id);
    }
}

