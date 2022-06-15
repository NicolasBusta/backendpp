package services.academicservice.converter;

import services.academicservice.dto.SectionDtoGet;
import services.academicservice.dto.SectionDtoPost;
import services.academicservice.entity.Section;
import services.academicservice.entity.Subject;
import services.academicservice.entity.Term;
import services.academicservice.repository.SubjectRepository;
import services.academicservice.repository.TermRepository;

public class SectionConverter {

    private TermRepository termRepository;
    private SubjectRepository subjectRepository;

    public SectionConverter(TermRepository termRepository, SubjectRepository subjectRepository) {
        this.termRepository = termRepository;
        this.subjectRepository = subjectRepository;
    }

    public SectionDtoGet entityToDTO(Section section) {
        SectionDtoGet dto = new SectionDtoGet();
        dto.setSectionName(section.getSectionName());
        dto.setSubjectDescription(section.getSubject().getSubjectDescription());
        dto.setTeacherName(null);
        dto.setTermDescription(section.getTerm().getTermDescription());
        dto.setSectionSize(section.getSectionSize());
        dto.setSectionQuote(null);
        dto.setSectionStatus(section.getSectionStatus());
        dto.setSectionR(null);

        return dto;
    }

    public Section dtoToEntity(SectionDtoPost dto) {
        Section section = new Section();

        section.setSectionStatus(dto.getSectionStatus());
        section.setSectionName(dto.getSectionName());
        if (dto.getModalityType().equals("Online Plus")) {
            section.setModalityType((short) 4);
        } else if (dto.getModalityType().equals("Presencial")) {
            section.setModalityType((short) 5);
        } else if (dto.getModalityType().equals("Semipresencial")) {
            section.setModalityType((short) 6);
        }
        Term term = this.termRepository.findTermBy(dto.getTermDescription());
        section.setTerm(term);
        Subject subject = this.subjectRepository.findSubjectBy(dto.getSubjectDescription());
        section.setSubject(subject);
        section.setSectionSize(dto.getSectionSize());
        if (dto.getLmsType().equals("Canvas")) {
            section.setLmsType((short) 14);
        } else if (dto.getLmsType().equals("EduSoft")) {
            section.setLmsType((short) 130);
        }

        return section;
    }

}
