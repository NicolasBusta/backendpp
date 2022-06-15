package services.academicservice.service;

import org.springframework.http.ResponseEntity;

import services.academicservice.dto.SubjectDtoGet;
import services.academicservice.dto.SubjectDtoPost;

import java.util.List;

public interface SubjectService {

    List<SubjectDtoGet> fetchAllSubjects();

    ResponseEntity<String> createSubject(SubjectDtoPost dto);

}
