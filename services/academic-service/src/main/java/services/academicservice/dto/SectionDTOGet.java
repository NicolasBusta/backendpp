package services.academicservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SectionDTOGet {

    private Long id;

    private String sectionName;

    private String subjectDescription;

    private String teacherName;

    private String termDescription;

    private Short sectionSize;

    private Short sectionQuote;

    private Boolean sectionStatus;

    private Boolean sectionR;

}
