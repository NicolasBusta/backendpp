package services.academicservice.converter;

import services.academicservice.dto.SubjectDtoGet;
import services.academicservice.dto.SubjectDtoPost;
import services.academicservice.entity.Subject;

public class SubjectConverter {

    public SubjectDtoGet entityToDTO(Subject subject) {
        SubjectDtoGet dto = new SubjectDtoGet();
        dto.setSubjectDescription(subject.getSubjectDescription());

        return dto;
    }

    public Subject dtoToEntity(SubjectDtoPost dto) {
        Subject subject = new Subject();
        subject.setSubjectCode(dto.getSubjectCode());
        subject.setSubjectDescription(dto.getSubjectDescription());
        subject.setSubjectStatus(dto.getSubjectStatus());
        subject.setSubjectType(dto.getSubjectType());
        subject.setSubjectHours(dto.getSubjectHours());
        subject.setSubjectCredits(dto.getSubjectCredits());
        subject.setExamType(dto.getExamType());

        return subject;
    }

}
