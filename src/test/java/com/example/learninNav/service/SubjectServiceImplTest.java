package com.example.learninNav.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.learninNav.entity.SubjectEntity;
import com.example.learninNav.exception.SubjectNotFoundException;
import com.example.learninNav.repository.SubjectRepository;

public class SubjectServiceImplTest {
    
    @Mock
    private SubjectRepository subjectRepository;

    @InjectMocks
    private SubjectServiceImpl subjectService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void findAllSubjectsTest() {
        SubjectEntity subject1 = new SubjectEntity(23, "Bengali", null);
        SubjectEntity subject2 = new SubjectEntity(12, "Geography", null);
        
        int expectedSubjectCount = 2;
        long expectedSubject1Id = 23;
        String expectedSubject2Name = "Geography";

        when(subjectRepository.findAll()).thenReturn(Arrays.asList(subject1, subject2));

        List<SubjectEntity> subjectList = subjectService.findAllSubjects();

        assertEquals(expectedSubjectCount, subjectList.size());
        assertEquals(expectedSubject2Name, subjectList.get(1).getSubjectName());
        assertEquals(expectedSubject1Id, subjectList.get(0).getSubjectId());
    }

    @Test
    public void findSubjectByIdTest() throws SubjectNotFoundException {
        SubjectEntity subject = new SubjectEntity();
        subject.setSubjectId(1);
        subject.setSubjectName("History");

        long expectedSubjectId = 1;
        String expectedSubjectName = "History";

        when(subjectRepository.findById(expectedSubjectId)).thenReturn(Optional.of(subject));

        SubjectEntity savedSubject = subjectService.findSubjectById(1);

        assertEquals(expectedSubjectName, savedSubject.getSubjectName());
    
    }

    @Test
    public void deleteSubjectTest_ExistingSubject() throws SubjectNotFoundException {
        long subjectId = 2;
        SubjectEntity existingSubject = new SubjectEntity();
        existingSubject.setSubjectId(subjectId);
        existingSubject.setSubjectName("PE");

        when(subjectService.findSubjectById(subjectId)).thenReturn(existingSubject);

        subjectService.deleteSubject(subjectId);

        verify(subjectRepository, times(1)).delete(existingSubject);

        assertEquals(0, subjectService.findAllSubjects().size());
    }

}
