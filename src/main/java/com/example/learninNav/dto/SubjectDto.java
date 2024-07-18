package com.example.learninNav.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubjectDto {
    
    private long subjectId;
    private String subjectName;

    @JsonIgnore
    private Set<StudentDto> studentList;
}
