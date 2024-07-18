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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learninNav.dto.SubjectDto;
import com.example.learninNav.entity.SubjectEntity;
import com.example.learninNav.exception.SubjectNotFoundException;
import com.example.learninNav.service.SubjectService;



@RestController
@RequestMapping("/subject")
public class SubjectController {
    
    @Autowired
    private SubjectService subjectService;

    @Autowired
    private ModelMapper modelMapper;

    public SubjectController(SubjectService subjectService) {
        super();
        this.subjectService = subjectService;
    }

    @GetMapping
    public List<SubjectDto> getAllSubjects() {

        return subjectService.findAllSubjects().stream().map(subjectEntity -> modelMapper.map(subjectEntity, SubjectDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectDto> findSubjectById(@PathVariable("id") long subjectId) throws SubjectNotFoundException {

        SubjectDto subject = modelMapper.map(subjectService.findSubjectById(subjectId), SubjectDto.class);

        return ResponseEntity.ok().body(subject);
    }

    @PostMapping
    public ResponseEntity<SubjectDto> createSubject(@RequestBody SubjectDto subjectDto) {

        SubjectEntity subjectRequest = modelMapper.map(subjectDto, SubjectEntity.class);

        SubjectEntity subject = subjectService.createSubject(subjectRequest);

        SubjectDto subjectResponse = modelMapper.map(subject, SubjectDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(subjectResponse);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable("id") long subjectId) throws SubjectNotFoundException {
        subjectService.deleteSubject(subjectId);
        return ResponseEntity.ok().body("{\"Successfully deleted the subject with id\": \"" + subjectId + "\"}");
    }
}
