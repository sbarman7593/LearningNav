package com.example.learninNav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learninNav.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    
}
