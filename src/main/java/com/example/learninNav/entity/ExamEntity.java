package com.example.learninNav.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exams")
public class ExamEntity {
    
    @Id
    @Column(name = "exam_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long examId;

    @OneToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private SubjectEntity subjectEntity;

    @ManyToMany(mappedBy = "enrolledExamList")
    private Set<StudentEntity> enrolledStudentList = new HashSet<>();
    
}
