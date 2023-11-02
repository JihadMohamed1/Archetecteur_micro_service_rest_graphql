package com.example.mcs1.Entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Student.class,name = "proj1")
public interface StudentProjection {
    public Long gitId();
    public String getFullName();
}
