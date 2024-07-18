package com.example.learninNav.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learninNav.entity.ExamEntity;
import com.example.learninNav.exception.ExamNotFoundException;
import com.example.learninNav.exception.SubjectNotFoundException;
import com.example.learninNav.repository.ExamRepository;

@Service
public class ExamServiceImpl implements ExamService{

    @Autowired
    private ExamRepository examRepository;

    @Override
    public ExamEntity createExam(ExamEntity examEntity) throws SubjectNotFoundException {
        return examRepository.save(examEntity);
    }

    @Override
    public ExamEntity findExamById(long examId) throws ExamNotFoundException {

        return examRepository.findById(examId).orElseThrow(() -> new ExamNotFoundException("Exam not found with id " + examId));
    }

    @Override
    public List<ExamEntity> findAllExams() {

        List<ExamEntity> examList = examRepository.findAll();
        return examList;

    }

    @Override
    public void deleteExam(long examId) throws ExamNotFoundException {
        ExamEntity exam = findExamById(examId);

        examRepository.delete(exam);
    }
    
}
