package services.academicservice.converter;

import services.academicservice.dto.SubjectDTOGet;
import services.academicservice.dto.SubjectDTOPost;
import services.academicservice.entity.Subject;

public class SubjectConverter {

    public SubjectDTOGet entityToDTO(Subject subject) {
        SubjectDTOGet dto = new SubjectDTOGet();
        dto.setId(subject.getId());
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

        return subject;
    }

}
