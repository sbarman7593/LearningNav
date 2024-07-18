package com.example.learninNav.service;

import java.util.List;

import com.example.learninNav.entity.SubjectEntity;
import com.example.learninNav.exception.SubjectNotFoundException;

public interface SubjectService {
    
    SubjectEntity createSubject(SubjectEntity subjectEntity);

    SubjectEntity findSubjectById(long subjectid) throws SubjectNotFoundException;

    List<SubjectEntity> findAllSubjects();

    void deleteSubject(long subjectid) throws SubjectNotFoundException;
    
}
