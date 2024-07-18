package com.example.learninNav.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learninNav.dto.ExamDto;
import com.example.learninNav.entity.ExamEntity;
import com.example.learninNav.exception.ExamNotFoundException;
import com.example.learninNav.exception.SubjectNotFoundException;
import com.example.learninNav.service.ExamService;

@RestController
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @Autowired
    private ModelMapper modelMapper;
    
    public ExamController(ExamService examService) {
        super();
        this.examService = examService;
    }

    @GetMapping
    public List<ExamDto> getAllExams() {
        return examService.findAllExams().stream().map(examEntity -> modelMapper.map(examEntity, ExamDto.class)).collect(Collectors.toList());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ExamDto> getExamById(@PathVariable("id") long examId) throws ExamNotFoundException {

        ExamDto exam = modelMapper.map(examService.findExamById(examId), ExamDto.class);

        return ResponseEntity.ok().body(exam);

    }

    @PutMapping
    public ResponseEntity<ExamDto> createExam(@RequestBody ExamDto examDto) throws SubjectNotFoundException {

        ExamEntity examRequest = modelMapper.map(examDto, ExamEntity.class);

        ExamEntity exam = examService.createExam(examRequest);

        ExamDto examResponse = modelMapper.map(exam, ExamDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(examResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExam(@PathVariable("id") long examId) throws ExamNotFoundException {
        examService.deleteExam(examId);

        return ResponseEntity.ok().body("{\"Successfully deleted the exam with id\": \"" + examId + "\"}");
    }
}
