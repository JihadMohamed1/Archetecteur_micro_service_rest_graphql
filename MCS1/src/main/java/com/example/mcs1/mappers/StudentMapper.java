package com.example.mcs1.mappers;

import com.example.mcs1.DTO.StudentDTOResponse;
import com.example.mcs1.Entities.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentDTOResponse fromStudent(Student student){
        StudentDTOResponse studentDTOResponse=new StudentDTOResponse();
        BeanUtils.copyProperties(student,studentDTOResponse);
        return studentDTOResponse;

    }
}
