package services.academicservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import services.academicservice.entity.Section;
import services.academicservice.entity.Subject;
import services.academicservice.entity.Term;

@Getter
@Setter
@NoArgsConstructor
public class SectionDtoGet {

    /* ACADEMIC_SECTIONS */
    private String sectionName;
    private Short sectionSize;
    private Boolean sectionStatus;

    /* ACADEMIC_SUBJECTS */
    private String subjectDescription;

    /* ACADEMIC_TERMS */
    private String termDescription;

    public SectionDtoGet(Section section, Subject subject, Term term) {
        this.sectionName = section.getSectionName();
        this.sectionSize = section.getSectionSize();
        this.sectionStatus = section.getSectionStatus();
        this.subjectDescription = subject.getSubjectDescription();
        this.termDescription = term.getTermDescription();
    }
}
