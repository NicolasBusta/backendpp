package services.academicservice.converter;

import services.academicservice.dto.SubjectDTOGet;
import services.academicservice.dto.SubjectDTOPost;
import services.academicservice.entity.Subject;

public class SubjectConverter {

    public SubjectDTOGet entityToDTO(Subject subject) {
        SubjectDTOGet dto = new SubjectDTOGet();
        dto.setSubjectCode(subject.getSubjectCode());
        dto.setSubjectDescription(subject.getSubjectDescription());
        Short subjectType = subject.getSubjectType();
        if (subjectType == 13) {
            dto.setSubjectType("Bimestral");
        } else if (subjectType == 127) {
            dto.setSubjectType("Práctica");
        } else if (subjectType == 128) {
            dto.setSubjectType("Seminario");
        } else if (subjectType == 129) {
            dto.setSubjectType("Examen");
        }
        dto.setSubjectStatus(subject.getSubjectStatus());
        dto.setSubjectCredits(subject.getSubjectCredits());
        dto.setSubjectHours(subject.getSubjectHours());

        return dto;
    }

    public Subject dtoToEntity(SubjectDTOPost dto) {
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
