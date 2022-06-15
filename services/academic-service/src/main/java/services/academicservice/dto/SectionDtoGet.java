package services.academicservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SectionDtoGet {

    private String sectionName;
    private Short sectionSize;
    private Short sectionQuote;
    private Boolean sectionStatus;
    private Boolean sectionR;
    private String teacherName;
    private String subjectDescription;
    private String termDescription;

}
