package com.example.learninNav.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learninNav.entity.SubjectEntity;
import com.example.learninNav.exception.SubjectNotFoundException;
import com.example.learninNav.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public SubjectEntity createSubject(SubjectEntity subjectEntity) {
        return subjectRepository.save(subjectEntity);
    }

    @Override
    public SubjectEntity findSubjectById(long subjectid) throws SubjectNotFoundException {
        
        return subjectRepository.findById(subjectid).orElseThrow(() -> new SubjectNotFoundException("Subject not found with id " + subjectid));
    }

    @Override
    public List<SubjectEntity> findAllSubjects() {
        List<SubjectEntity> subjectList = subjectRepository.findAll();

        return subjectList;
    }

    @Override
    public void deleteSubject(long subjectid) throws SubjectNotFoundException {
        SubjectEntity subject = findSubjectById(subjectid);

        subjectRepository.delete(subject);
        
    }
    
}
