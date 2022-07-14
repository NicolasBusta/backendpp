package services.academicservice.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import services.academicservice.dto.SectionDTOGet;
import services.academicservice.dto.SectionDTOPost;
import services.academicservice.entity.Section;
import services.academicservice.entity.Subject;
import services.academicservice.entity.Term;
import services.academicservice.repository.DepartmentRepository;
import services.academicservice.repository.SubjectDepartmentRepository;
import services.academicservice.repository.SubjectRepository;
import services.academicservice.repository.TermRepository;

@Component
public class SectionConverter {


    private TermRepository termRepository;
    private SubjectRepository subjectRepository;
    private DepartmentRepository departmentRepository;
    private SubjectDepartmentRepository subjectDepartmentRepository;

    @Autowired
    public SectionConverter (TermRepository termRepository,
                                       SubjectRepository subjectRepository,
                                       DepartmentRepository departmentRepository,
                                       SubjectDepartmentRepository subjectDepartmentRepository) {
        this.termRepository = termRepository;
        this.subjectRepository = subjectRepository;
        this.departmentRepository = departmentRepository;
        this.subjectDepartmentRepository = subjectDepartmentRepository;
    }

    public SectionDTOGet entityToDTO(Section section) {
        SectionDTOGet dto = new SectionDTOGet();

        dto.setId(section.getId());
        dto.setSectionName(section.getSectionName());
        dto.setSubjectDescription(section.getSubject().getSubjectDescription());
        dto.setTeacherName(null);
        dto.setTermDescription(section.getTerm().getTermDescription());
        dto.setSectionSize(section.getSectionSize());
        dto.setSectionQuote(null);
        dto.setSectionStatus(section.getSectionStatus());
        dto.setSectionR(false);

        return dto;
    }

    public Section dtoToEntity(SectionDTOPost dto) {
        Section section = new Section();

        section.setSectionStatus(dto.getSectionStatus()); // Habilitado
        section.setSectionName(dto.getSectionName()); // Nombre

        if (dto.getModalityType().equals("Presencial")) { // Modalidad
            section.setModalityType((short) 5);
        } else if (dto.getModalityType().equals("Semipresencial")) {
            section.setModalityType((short) 6);
        } else {
            section.setModalityType((short) 4); // 4: Online Plus
        }

        Term term = termRepository.findTermBy(dto.getTermDescription()); // Período
        section.setTerm(term);

        if (dto.getLmsType().equals("Canvas")) { // LMS
            section.setLmsType((short) 14);
        } else if (dto.getLmsType().equals("EduSoft")) {
            section.setLmsType((short) 130);
        }

        Subject subject = subjectRepository.findSubjectBy(dto.getSubjectDescription()); // Asignatura
        section.setSubject(subject);

        section.setSectionSize(dto.getSectionSize()); // Cupo

        return section;

    }

}
