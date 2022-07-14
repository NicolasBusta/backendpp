package services.academicservice.service;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import services.academicservice.converter.SubjectConverter;
import services.academicservice.dto.SubjectDTOGet;
import services.academicservice.dto.SubjectDTOPost;
import services.academicservice.entity.Subject;
import services.academicservice.exception.CareerNotFoundException;
import services.academicservice.repository.SubjectRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectConverter subjectConverter;

    @Autowired
    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
        this.subjectConverter = new SubjectConverter();
    }

    /**
     *
     * @return list of subjects
     */
    public List<SubjectDTOGet> fetchAllSubjects() {
        List<Subject> subjectList = subjectRepository.getDistinctSubjects();
        List<SubjectDTOGet> dtoList = new ArrayList<>();
        for (Subject subject : subjectList) {
            dtoList.add(subjectConverter.entityToDTO(subject));
        }
        return dtoList;
    }

    /**
     *
     * @return list of subjects description
     */
    public List<String> fetchAllSubjectsDescription() {
        return subjectRepository.getDistinctSubjectsByName();
    }

    /**
     *
     * @param id id of subject to be searched
     * @return subject object which id correlate with the request
     */
    public SubjectDTOGet fetchSubjectById(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "Subject"));

        return subjectConverter.entityToDTO(subject);
    }

    /**
     *
     * @param dto DTO which contains specified fields for different tables
     * @return responseEntity object which contains a message and a HTTP status
     */
    public ResponseEntity<String> createSubject(SubjectDTOPost dto) {
        String newSubjectDescription = dto.getSubjectDescription();
        String newSubjectCode = dto.getSubjectCode();
        if (subjectRepository.findAllSubjectsBy(newSubjectDescription, newSubjectCode).isEmpty()) {
            Subject subject = subjectConverter.dtoToEntity(dto);
            subjectRepository.save(subject);
            return new ResponseEntity<>("Subject created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Subject already exists", HttpStatus.CONFLICT);
        }
    }

    /**
     *
     * @param dto DTO which contains specified fields for different tables
     * @return responseEntity object which contains a message and a HTTP status
     */
    public ResponseEntity<String> updateSubject(Long id, SubjectDTOPost dto) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "Subject id not found"));
        String newSubjectDescription = dto.getSubjectDescription();
        String newSubjectCode = dto.getSubjectCode();

        int subjects = subjectRepository.findAllSubjectsBy(newSubjectDescription, newSubjectCode).size();
        if (subjects >= 1) {
            return new ResponseEntity<>("Subject already exists", HttpStatus.CONFLICT);
        } else {

            subject.setSubjectStatus(dto.getSubjectStatus());

            subject.setSubjectDescription(dto.getSubjectDescription());
            subject.setSubjectCode(dto.getSubjectCode());

            switch (dto.getSubjectType()) {
                case "Bimestral":
                    subject.setSubjectType((short) 13);
                    break;
                case "Práctica":
                    subject.setSubjectType((short) 127);
                    break;
                case "Seminario":
                    subject.setSubjectType((short) 128);
                    break;
                case "Examen":
                    subject.setSubjectType((short) 129);
                    break;
            }


            subject.setSubjectCredits(dto.getSubjectCredits());
            subject.setSubjectHours(dto.getSubjectHours());

            switch (dto.getSubjectDuration()) {
                case "Bimestral":
                    subject.setSubjectDuration((short) 49);
                    break;
                case "Semestral":
                    subject.setSubjectDuration((short) 50);
                    break;
            }

            switch (dto.getExamType()) {
                case "Normal (22 Preguntas)":
                    subject.setExamType((short) 146);
                    break;
                case "Complejo (9 Preguntas)":
                    subject.setExamType((short) 147);
                    break;
                case "Sin Examen":
                    subject.setExamType((short) 148);
                    break;
                case "Sin Examen (Nota 5)":
                    subject.setExamType((short) 149);
                    break;
                case "Normal (30 Preguntas)":
                    subject.setExamType((short) 226);
                    break;
            }

            subjectRepository.save(subject);
            return new ResponseEntity<>("Subject updated successfully", HttpStatus.OK);
        }
    }

    /**
     *
     * @param id id of career to be searched
     * @return responseEntity object which contains a message and a HTTP status
     */
    public ResponseEntity<String> deleteSubject(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new CareerNotFoundException("Subject id not found - " + id));
        subjectRepository.delete(subject);
        return new ResponseEntity<>("Subject deleted successfully", HttpStatus.OK);
    }

}
