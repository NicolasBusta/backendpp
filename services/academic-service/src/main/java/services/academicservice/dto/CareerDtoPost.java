package services.academicservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class CareerDtoPost {

    public final static String REGEX = "^[A-Za-záéíóúÁÉÍÓÚ]+( [A-Za-záéíóúÁÉÍÓÚ]+)*$";
    public final static String REGEX_TWO = "^[0-9A-Za-záéíóúÁÉÍÓÚ]+( [0-9A-Za-záéíóúÁÉÍÓÚ]+)*$";

    @Pattern(regexp=REGEX,message = "Invalid Input")
    private String description;

    @Pattern(regexp=REGEX,message = "Invalid input")
    private String legalDescription;

    private Boolean status;

    @Size(min = 1, max = 6, message = "Must be between 1 and 6 characters")
    @Pattern(regexp=REGEX_TWO, message = "Invalid input")
    private String code;

    @Positive(message = "Must be greater than 0")
    @NotNull
    private Short careerType;

    @Positive(message = "Must be greater than 0")
    @NotNull
    private Long careerCredits;

    @Positive(message = "Must be greater than 0")
    @NotNull
    private Long careerHours;

    @Positive(message = "Must be greater than 0")
    @NotNull
    private Short book;

    @Positive(message = "Must be greater than 0")
    @NotNull
    private Short invoice;
}
