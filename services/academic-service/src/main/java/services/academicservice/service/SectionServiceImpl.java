package services.academicservice.service;

import org.hibernate.ObjectNotFoundException;
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
    private TermRepository termRepository;
    private SubjectRepository subjectRepository;
    private final DepartmentRepository departmentRepository;
    private final SectionTeacherRepository sectionTeacherRepository;
    private final TeacherRepository teacherRepository;
    private final SectionConverter sectionConverter;

    @Autowired
    public SectionServiceImpl(SectionRepository sectionRepository,
            TermRepository termRepository,
            SubjectRepository subjectRepository,
            DepartmentRepository departmentRepository,
            SectionTeacherRepository sectionTeacherRepository,
            TeacherRepository teacherRepository) {
        this.sectionRepository = sectionRepository;
        this.departmentRepository = departmentRepository;
        this.sectionTeacherRepository = sectionTeacherRepository;
        this.teacherRepository = teacherRepository;
        this.sectionConverter = new SectionConverter(termRepository, subjectRepository);
    }

    /**
     *
     * @param pageNo    page number to display
     * @param pageSize  number of objects shown per page
     * @param direction ascendant or descendant
     * @param sortBy    field to be ordered by
     * @return list of section DTO objects
     */
    public List<SectionDTOGet> fetchAllSections(Integer pageNo, Integer pageSize, String sortBy, String direction) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.Direction.fromString(direction), sortBy);
        Page<Section> sections = sectionRepository.findAll(paging);
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
        if (sectionRepository.findAllSectionsBy(newName).isEmpty()) {
            Section section = sectionConverter.dtoToEntity(dto);
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
            section.setSectionEnable(dto.getSectionEnable());
            section.setSectionName(dto.getSectionName());

            switch (dto.getModalityType()) {
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

            Long sectionId = section.getId();
            SectionTeacher sectionTeacher = sectionTeacherRepository.findById(sectionId)
                    .orElseThrow(() -> new ObjectNotFoundException(sectionId, "SectionTeacher"));
            UserData userData = new UserData();
            List<UserData> userList = userData.getUserList();
            Long userId = null;
            for (UserData user : userList) {
                String fullname = user.getUserDataName().concat(user.getUserDataLastName());
                if (dto.getTeacherName().equals(fullname)) {
                    userId = user.getId();
                }
            }
            Teacher teacher = teacherRepository.findByUserId(userId);
            sectionTeacher.setTeacher(teacher);

            sectionRepository.save(section);
            subjectRepository.save(subject);
            sectionTeacherRepository.save(sectionTeacher);
            return new ResponseEntity<>("Section updated successfully", HttpStatus.OK);
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
        return new ResponseEntity<>("Section deleted successfully", HttpStatus.OK);
    }

}
