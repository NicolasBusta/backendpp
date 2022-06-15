package services.academicservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
public class SectionDtoPost {

    public final static String REGEX = "^[A-Za-záéíóúÁÉÍÓÚ]+( [A-Za-záéíóúÁÉÍÓÚ]+)*$";

    private Boolean sectionStatus;

    @Pattern(regexp=REGEX,message = "Invalid Input")
    @NotNull
    private String sectionName;

    private String modalityType;

    private String termDescription;

    private String lmsType;

    private String departmentName;

    private String subjectDescription;

    @Positive(message = "Must be greater than 0")
    @NotNull
    private Short sectionSize;

    private String teacherName;

}
