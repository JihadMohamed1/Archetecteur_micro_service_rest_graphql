package com.example.mcs1.Repos;

import com.example.mcs1.Entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepo extends JpaRepository<Classroom,Long> {
}
