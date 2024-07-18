package com.example.learninNav.service;

import com.example.learninNav.entity.StudentEntity;
import com.example.learninNav.exception.ExamNotFoundException;
import com.example.learninNav.exception.StudentNotFoundException;
import com.example.learninNav.exception.SubjectNotEnrolledException;
import com.example.learninNav.exception.SubjectNotFoundException;

import java.util.List;


public interface StudentService {

    List<StudentEntity> findAllStudents();

    StudentEntity registerStudent(StudentEntity studentEntity);
    
    StudentEntity enrollStudentForSubject(long studentId, long subjectId) throws StudentNotFoundException, SubjectNotFoundException;
    
    void deregisterStudent(long id) throws StudentNotFoundException;
    
    StudentEntity findStudentById(long id) throws StudentNotFoundException;
    
    StudentEntity enrollStudentForExam(long studentId, long examId) throws StudentNotFoundException, ExamNotFoundException, SubjectNotEnrolledException;
    
}
