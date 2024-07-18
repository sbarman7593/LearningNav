package com.example.learninNav.service;

import java.util.List;

import com.example.learninNav.entity.ExamEntity;
import com.example.learninNav.exception.ExamNotFoundException;
import com.example.learninNav.exception.SubjectNotFoundException;

public interface ExamService {
    
    ExamEntity createExam(ExamEntity examEntity) throws SubjectNotFoundException;

    ExamEntity findExamById(long examId) throws ExamNotFoundException;

    List<ExamEntity> findAllExams();

    void deleteExam(long examId) throws ExamNotFoundException;
}
