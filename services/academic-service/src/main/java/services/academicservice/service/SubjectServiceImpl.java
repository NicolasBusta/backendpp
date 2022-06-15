package services.academicservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import services.academicservice.converter.SubjectConverter;
import services.academicservice.dto.SubjectDtoGet;
import services.academicservice.dto.SubjectDtoPost;
import services.academicservice.entity.Subject;
import services.academicservice.repository.SubjectRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl {

    private SubjectRepository subjectRepository;
    private SubjectConverter subjectConverter;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
        this.subjectConverter = new SubjectConverter();
    }

    public List<SubjectDtoGet> fetchAllSubjects() {
        List<String> subjectList = subjectRepository.getDistinctSubjectsByName();
        List<SubjectDtoGet> dtoList = new ArrayList<>();
        for (String subject : subjectList) {
            Subject newSubject = new Subject();
            newSubject.setSubjectDescription(subject);
            dtoList.add(subjectConverter.entityToDTO(newSubject));
        }
        return dtoList;
    }

    /**
     *
     * @param dto DTO which contains specified fields for different tables
     * @return responseEntity object which contains a message and a HTTP status
     */
    public ResponseEntity<String> createSubject(SubjectDtoPost dto) {
        String newSubjectDescription = dto.getSubjectDescription();
        String newSubjectCode = dto.getSubjectCode();
        if (subjectRepository.findAllSubjectsBy(newSubjectDescription, newSubjectCode).isEmpty()) {
            Subject subject = subjectConverter.dtoToEntity(dto);
            subjectRepository.save(subject);
            return new ResponseEntity<String>("Career created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Career already exists", HttpStatus.CONFLICT);
        }
    }

}
