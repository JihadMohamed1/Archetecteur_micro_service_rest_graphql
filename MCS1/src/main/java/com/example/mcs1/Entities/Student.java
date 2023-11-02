package com.example.mcs1.Entities;

import com.example.mcs1.Enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity

@Data @AllArgsConstructor @NoArgsConstructor @Builder

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @Column(length = 50, nullable = false)

    private String fullName;

    @Temporal(TemporalType.DATE) @Column(nullable = false)

    private Date birthDate;

    @Column(length = 8, unique = true, nullable = false)

    private String NID; //CIN

    @Column(nullable = false)@Enumerated(EnumType.STRING)

    private Gender gender;

    @Column(nullable = false)

    private String contactNo;

    @Column(length = 108 , nullable = false)

    private String address;

    @Column(nullable = false)

    private Boolean enabled;
    @ManyToOne
    private Classroom classroom;
}

