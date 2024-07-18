package com.example.learninNav.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.learninNav.entity.SubjectEntity;


public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
    
}
