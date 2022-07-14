package services.academicservice.service;

import org.springframework.http.ResponseEntity;
import services.academicservice.dto.SubjectDTOGet;
import services.academicservice.dto.SubjectDTOPost;

import java.util.List;

public interface SubjectService {

    List<SubjectDTOGet> fetchAllSubjects();

    List<String> fetchAllSubjectsDescription();

    SubjectDTOGet fetchSubjectById(Long id);

    ResponseEntity<String> createSubject(SubjectDTOPost dto);

    ResponseEntity<String> updateSubject(Long id, SubjectDTOPost dto);

    ResponseEntity<String> deleteSubject(Long id);

}
