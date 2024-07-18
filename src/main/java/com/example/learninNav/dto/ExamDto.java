package com.example.learninNav.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExamDto {
    
    private long examId;
    private SubjectDto subjectDto;

    @JsonIgnore
    private Set<StudentDto> enrolledStudentList;

}
