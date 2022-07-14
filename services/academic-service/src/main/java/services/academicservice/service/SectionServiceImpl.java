package services.academicservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import services.academicservice.converter.SectionConverter;
import services.academicservice.dto.SectionDTOGet;
import services.academicservice.dto.SectionDTOPost;
import services.academicservice.entity.*;
import services.academicservice.exception.SectionNotFoundException;
import services.academicservice.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {

    private final SectionRepository sectionRepository;
    private final TermRepository termRepository;
    private final SubjectRepository subjectRepository;
    private final DepartmentRepository departmentRepository;
    private final SubjectDepartmentRepository subjectDepartmentRepository;
    private final SectionConverter sectionConverter;

    @Autowired
    public SectionServiceImpl(SectionRepository sectionRepository,
                              TermRepository termRepository,
                              SubjectRepository subjectRepository,
                              DepartmentRepository departmentRepository,
                              SubjectDepartmentRepository subjectDepartmentRepository) {
        this.sectionRepository = sectionRepository;
        this.departmentRepository = departmentRepository;
        this.subjectDepartmentRepository = subjectDepartmentRepository;
        this.termRepository = termRepository;
        this.subjectRepository = subjectRepository;
        this.sectionConverter = new SectionConverter(termRepository, subjectRepository, departmentRepository, subjectDepartmentRepository);
    }


    public List<SectionDTOGet> fetchAllSections(Integer pageNo, Integer pageSize, String sortBy, String direction) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.Direction.fromString(direction), sortBy);
        Page<Section> sections = sectionRepository.findAll(paging);
        List<SectionDTOGet> sectionDtoGetList = new ArrayList<>();
        for (Section section : sections) {
            sectionDtoGetList.add(sectionConverter.entityToDTO(section));
        }
        return sectionDtoGetList;
    }


    public List<SectionDTOGet> fetchAllSection() {
        List<Section> sections = sectionRepository.findAll();
        List<SectionDTOGet> sectionDtoGetList = new ArrayList<>();
        for (Section section : sections) {
            sectionDtoGetList.add(sectionConverter.entityToDTO(section));
        }
        return sectionDtoGetList;
    }

    /**
     *
     * @param id id of section to be searched
     * @return section object which id correlate with the request
     */
    public SectionDTOGet fetchSectionById(Long id) {
        Section section = sectionRepository.findById(id)
                .orElseThrow(() -> new SectionNotFoundException("Section id not found - " + id));
        return sectionConverter.entityToDTO(section);
    }

    /**
     *
     * @param dto DTO which contains specified fields for different tables
     * @return responseEntity object which contains a message and an HTTP status
     */
    public ResponseEntity<String> createSection(SectionDTOPost dto) {
        String newName = dto.getSectionName();
        //String newTermDescription = dto.getTermDescription();
        if (sectionRepository.findAllSectionsBy(newName).isEmpty()) {
            Section section = sectionConverter.dtoToEntity(dto);

            Subject subject = subjectRepository.findSubjectBy(dto.getSubjectDescription());
            Department department = departmentRepository.findDepartmentBy(dto.getDepartmentName());

            if (!subjectDepartmentRepository.existsByDepartmentIdAndSubjectId(department.getId(), subject.getId())) {
                SubjectDepartment subjectDepartment2 = new SubjectDepartment();
                subjectDepartment2.setSubject(subject);
                subjectDepartment2.setDepartment(department);
                subjectDepartmentRepository.save(subjectDepartment2);
            }

            sectionRepository.save(section);

            return new ResponseEntity<>("Section created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Section already exists", HttpStatus.CONFLICT);
        }
    }

    /**
     *
     * @param id  id of section to be searched
     * @param dto DTO which contains specified fields for different tables
     * @return responseEntity object which contains a message and an HTTP status
     */
    public ResponseEntity<String> updateSection(Long id, SectionDTOPost dto) {
        Section section = sectionRepository.findById(id)
                .orElseThrow(() -> new SectionNotFoundException("Section id not found - " + id));

        String newName = dto.getSectionName();

        int sections = sectionRepository.findAllSectionsBy(newName).size();
        if (sections >= 1) {
            return new ResponseEntity<>("Section already exists", HttpStatus.CONFLICT);
        } else {
            section.setSectionName(newName); // Nombre

            switch (dto.getModalityType()) { // Modalidad
                case "Online Plus":
                    section.setModalityType((short) 4);
                    break;
                case "Presencial":
                    section.setModalityType((short) 5);
                    break;
                case "Semipresencial":
                    section.setModalityType((short) 6);
                    break;
            }

            Term term = termRepository.findTermBy(dto.getTermDescription()); //
            section.setTerm(term); // Periodo

            if (dto.getLmsType().equals("Canvas")) { // LMS
                section.setModalityType((short) 14);
            } else if (dto.getLmsType().equals("EduSoft")) {
                section.setModalityType((short) 130);
            }

            Subject subject = subjectRepository.findSubjectBy(dto.getSubjectDescription());
            section.setSubject(subject); // Subject

            Department department = departmentRepository.findDepartmentBy(dto.getDepartmentName());

            section.setSectionSize(dto.getSectionSize()); // Size

        }

        sectionRepository.save(section);

        return new ResponseEntity<>("Section updated successfully", HttpStatus.OK);

    }

    /**
     *
     * @param id id of section to be searched
     * @return responseEntity object which contains a message and an HTTP status
     */
    public ResponseEntity<String> deleteSectionById(Long id) {
        Section section = sectionRepository.findById(id)
                .orElseThrow(() -> new SectionNotFoundException("Section id not found - " + id));
        sectionRepository.delete(section);
        return new ResponseEntity<>("Section deleted successfully", HttpStatus.OK);
    }

}
