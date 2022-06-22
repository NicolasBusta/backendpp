package services.academicservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import services.academicservice.converter.SectionConverter;
import services.academicservice.dto.SectionDtoGet;
import services.academicservice.dto.SectionDtoPost;
import services.academicservice.entity.Department;
import services.academicservice.entity.Section;
import services.academicservice.entity.Subject;
import services.academicservice.exception.SectionNotFoundException;
import services.academicservice.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionServiceImpl {

    private SectionRepository sectionRepository;
    private TermRepository termRepository;
    private SubjectRepository subjectRepository;
    private DepartmentRepository departmentRepository;
    private SectionConverter sectionConverter;

    public SectionServiceImpl(SectionRepository sectionRepository, TermRepository termRepository, SubjectRepository subjectRepository) {
        this.sectionRepository = sectionRepository;
        this.sectionConverter = new SectionConverter(termRepository, subjectRepository);
    }

    /**
     *
     * @param pageNo page number to display
     * @param pageSize number of objects shown per page
     * @param direction ascendant or descendant
     * @param sortBy field to be ordered by
     * @return list of section DTO objects
     */
    public List<SectionDtoGet> fetchAllSections(Integer pageNo, Integer pageSize, String sortBy, String direction) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.Direction.fromString(direction), sortBy);
        Page<Section> sections = sectionRepository.findAll(paging);
        List<SectionDtoGet> sectionDtoGetList = new ArrayList<>();
        for (Section section: sections) {
            sectionDtoGetList.add(sectionConverter.entityToDTO(section));
        }
        return sectionDtoGetList;
    }

    /**
     *
     * @param id id of section to be searched
     * @return section object which id correlate with the request
     */
    public SectionDtoGet fetchSectionById(Long id) {
        Section section = sectionRepository.findById(id)
                .orElseThrow(() -> new SectionNotFoundException("Section id not found - " + id));
        SectionDtoGet sectionDtoGet = sectionConverter.entityToDTO(section);
        return sectionDtoGet;
    }

    /**
     *
     * @param dto DTO which contains specified fields for different tables
     * @return responseEntity object which contains a message and an HTTP status
     */
    public ResponseEntity<String> createSection(SectionDtoPost dto) {
        String newName = dto.getSectionName();
        if (sectionRepository.findAllSectionsBy(newName).isEmpty()) {
            Section section = sectionConverter.dtoToEntity(dto);
            sectionRepository.save(section);
            return new ResponseEntity<String>("Section created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Section already exists", HttpStatus.CONFLICT);
        }
    }

    /**
     *
     * @param id id of section to be searched
     * @param dto DTO which contains specified fields for different tables
     * @return responseEntity object which contains a message and an HTTP status
     */
    public ResponseEntity<String> updateSection(Long id, SectionDtoPost dto) {
        Section section = sectionRepository.findById(id)
                .orElseThrow(() -> new SectionNotFoundException("Section id not found - " + id));
        String newName = dto.getSectionName();
        int sections = sectionRepository.findAllSectionsBy(newName).size();
        if (sections >= 1) {
            return new ResponseEntity<String>("Section already exists", HttpStatus.CONFLICT);
        } else {
            section.setSectionEnable(dto.getSectionEnable());
            section.setSectionName(dto.getSectionName());

            if (dto.getModalityType().equals("Online Plus")) {
                section.setModalityType((short) 4);
            } else if (dto.getModalityType().equals("Presencial")) {
                section.setModalityType((short) 5);
            } else if (dto.getModalityType().equals("Semipresencial")) {
                section.setModalityType((short) 6);
            }

            section.getTerm().setTermDescription(dto.getTermDescription());

            if (dto.getLmsType().equals("Canvas")) {
                section.setModalityType((short) 14);
            } else if (dto.getLmsType().equals("EduSoft")) {
                section.setModalityType((short) 130);
            }

            Subject subject = subjectRepository.findSubjectBy(dto.getSubjectDescription());
            section.setSubject(subject);

            Department department = departmentRepository.findDepartmentBy(dto.getDepartmentName());
            subject.getSubjectDepartment().setDepartmentSubject(department);

            section.setSectionSize(dto.getSectionSize());

            sectionRepository.save(section);
            subjectRepository.save(subject);
            return new ResponseEntity<String>("Section updated successfully", HttpStatus.OK);
        }
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
        return new ResponseEntity<String>("Section deleted successfully", HttpStatus.OK);
    }

}
