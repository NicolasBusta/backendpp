package services.academicservice.service;

import org.springframework.http.ResponseEntity;

import services.academicservice.dto.SubjectDTOGet;
import services.academicservice.dto.SubjectDTOPost;

import java.util.List;

public interface SubjectService {

    List<SubjectDTOGet> fetchAllSubjects();

    ResponseEntity<String> createSubject(SubjectDTOPost dto);

}
