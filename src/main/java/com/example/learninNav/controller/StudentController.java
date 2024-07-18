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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.learninNav.service.StudentService;
import com.example.learninNav.dto.StudentDto;
import com.example.learninNav.entity.StudentEntity;
import com.example.learninNav.exception.ExamNotFoundException;
import com.example.learninNav.exception.StudentNotFoundException;
import com.example.learninNav.exception.SubjectNotEnrolledException;
import com.example.learninNav.exception.SubjectNotFoundException;

@RestController
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @Autowired
	private ModelMapper modelMapper;


    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.findAllStudents().stream().map(studentEntity -> modelMapper.map(studentEntity, StudentDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") long studentId) throws StudentNotFoundException{
        StudentEntity studentEntity = studentService.findStudentById(studentId);

        StudentDto postStudentDto = modelMapper.map(studentEntity, StudentDto.class);

        return ResponseEntity.ok().body(postStudentDto);
    }
    

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {

        StudentEntity studentRequest = modelMapper.map(studentDto, StudentEntity.class);

        StudentEntity student = studentService.registerStudent(studentRequest);

        StudentDto studentResponse = modelMapper.map(student, StudentDto.class);

        return new ResponseEntity<StudentDto>(studentResponse, HttpStatus.CREATED);

    }

    @PutMapping("/{studentid}/exam/{examid}")
    public ResponseEntity<StudentDto> registerStudentToExam(@PathVariable("studentid") long studentId, @PathVariable("examid") long examId) throws StudentNotFoundException, ExamNotFoundException, SubjectNotEnrolledException {
        
        StudentDto student = modelMapper.map(studentService.enrollStudentForExam(studentId, examId), StudentDto.class);

        return ResponseEntity.ok().body(student);
    }

    
    @PutMapping("/{studentid}/subject/{subjectid}")
    public ResponseEntity<StudentDto> enrolledStudentForSubject(@PathVariable("studentid") long studentId, @PathVariable("subjectid") long subjectId) throws StudentNotFoundException, SubjectNotFoundException {

        StudentDto student = modelMapper.map(studentService.enrollStudentForSubject(studentId, subjectId), StudentDto.class);

        return ResponseEntity.ok().body(student);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") long studentId) throws StudentNotFoundException {
        studentService.deregisterStudent(studentId);
        return ResponseEntity.ok().body("{\"Successfully deleted the id\": \"" + studentId + "\"}");
    }
}
