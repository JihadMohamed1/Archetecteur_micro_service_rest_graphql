package com.example.mcs1.DTO;

import com.example.mcs1.Entities.Classroom;
import com.example.mcs1.Enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor @NoArgsConstructor
public class StudentDTORequest {
    private String fullName;
    private Date birtDate;
    private String NID;
    private Gender gender;
    private String contactNo;
    private String adress;
    private Boolean enabled;
    private Classroom classroom;
}
