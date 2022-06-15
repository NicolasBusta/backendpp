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
public class SubjectDtoPost {

    public final static String REGEX = "^[A-Za-záéíóúÁÉÍÓÚ]+( [A-Za-záéíóúÁÉÍÓÚ]+)*$";
    public final static String REGEX_TWO = "^[0-9A-Za-záéíóúÁÉÍÓÚ]+( [0-9A-Za-záéíóúÁÉÍÓÚ]+)*$";

    private Boolean subjectStatus;

    @Pattern(regexp=REGEX,message = "Invalid Input")
    @NotNull
    private String subjectDescription;

    @Pattern(regexp=REGEX_TWO,message = "Invalid Input")
    @NotNull
    private String subjectCode;

    @Positive(message = "Must be greater than 0")
    @NotNull
    private Short subjectType;

    @Positive(message = "Must be greater than 0")
    @NotNull
    private Long subjectHours;

    @Positive(message = "Must be greater than 0")
    @NotNull
    private Long subjectCredits;

    @Positive(message = "Must be greater than 0")
    @NotNull
    private Short examType;

}
