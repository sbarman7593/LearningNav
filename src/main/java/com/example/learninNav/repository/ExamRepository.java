package com.example.learninNav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learninNav.entity.ExamEntity;

public interface ExamRepository extends JpaRepository<ExamEntity, Long>{
    
}
