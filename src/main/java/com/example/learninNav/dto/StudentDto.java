package com.example.learninNav.dto;

import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDto {
    
    private long studentId;
    private String studentName;
    private Set<SubjectDto> enrolledSubjectList;
    private Set<ExamDto> enrolledExamList;
    
}
