package com.example.learninNav.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learninNav.entity.ExamEntity;
import com.example.learninNav.entity.StudentEntity;
import com.example.learninNav.entity.SubjectEntity;
import com.example.learninNav.exception.ExamNotFoundException;
import com.example.learninNav.exception.StudentNotFoundException;
import com.example.learninNav.exception.SubjectNotEnrolledException;
import com.example.learninNav.exception.SubjectNotFoundException;
import com.example.learninNav.repository.ExamRepository;
import com.example.learninNav.repository.StudentRepository;
import com.example.learninNav.repository.SubjectRepository;

@Service
public class StudentServiceImpl implements StudentService{
    
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ExamRepository examRepository;


    @Override
    public List<StudentEntity> findAllStudents() {
        List<StudentEntity> studentList = studentRepository.findAll();
        return studentList;
    }


    @Override
    public StudentEntity registerStudent(StudentEntity studentEntity) {
        
        return studentRepository.save(studentEntity);
    }

    @Override
    public StudentEntity findStudentById(long id) throws StudentNotFoundException {
        
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found for given id " + id));
    
    }


    @Override
    public void deregisterStudent(long id) throws StudentNotFoundException {
        
        StudentEntity student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found for given id " + id));
        studentRepository.delete(student);
    }


    @Override
    public StudentEntity enrollStudentForExam(long studentId, long examId) throws StudentNotFoundException, ExamNotFoundException, SubjectNotEnrolledException{
        StudentEntity student = findStudentById(studentId);

        ExamEntity exam = examRepository.findById(examId).orElseThrow(() -> new ExamNotFoundException("Exam not found with id " + examId));

        SubjectEntity subject = exam.getSubjectEntity();
        if (!student.getEnrolledSubjectList().contains(subject)) {
            throw new SubjectNotEnrolledException("Student must be enrolled in the subject to register before in exam!" );
        }

        student.getEnrolledExamList().add(exam);

        return studentRepository.save(student);
    }


    @Override
    public StudentEntity enrollStudentForSubject(long studentId, long subjectId) throws SubjectNotFoundException, StudentNotFoundException {

        StudentEntity student = findStudentById(studentId);

        SubjectEntity subject = subjectRepository.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException("Subject not found with id " + subjectId));
        
        student.getEnrolledSubjectList().add(subject);

        return studentRepository.save(student);
        
    }
}
