package services.academicservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CareerDTOPost {

    public final static String REGEX = "^[A-Za-záéíóúÁÉÍÓÚ]+( [A-Za-záéíóúÁÉÍÓÚ]+)*$";
    public final static String REGEX_TWO = "^[0-9A-Za-záéíóúÁÉÍÓÚ]+( [0-9A-Za-záéíóúÁÉÍÓÚ]+)*$";

    @Pattern(regexp=REGEX,message = "Invalid Input")
    @NotNull
    private String description;

    @Pattern(regexp=REGEX,message = "Invalid input")
    private String legalDescription;

    private Boolean status;

    @Size(min = 1, max = 6, message = "Must be between 1 and 6 characters")
    @Pattern(regexp=REGEX_TWO, message = "Invalid input")
    @NotNull
    private String code;

    private String careerType;

    @Positive(message = "Must be greater than 0")
    @NotNull
    private Long careerCredits;

    @Positive(message = "Must be greater than 0")
    @NotNull
    private Long careerHours;

    @Positive(message = "Must be greater than 0")
    private Short book;

    @Positive(message = "Must be greater than 0")
    private Short invoice;

}
