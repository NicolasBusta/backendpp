package services.academicservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@NoArgsConstructor
public class CareerDtoPost {

    public final static String REGEX = "^[A-Za-záéíóúÁÉÍÓÚ]+( [A-Za-záéíóúÁÉÍÓÚ]+)*$";

    @Pattern(regexp=REGEX,message = "Invalid Input")
    private String description;

    @Pattern(regexp=REGEX,message = "Invalid Input")
    private String legalDescription;

    private Boolean status;

    @Pattern(regexp=REGEX,message = "Invalid Input")
    private String code;

    @Positive
    @NotNull(message = "Invalid Input")
    private Short careerType;

    @PositiveOrZero
    @NotNull(message = "Invalid Input")
    private Long careerCredits;

    @PositiveOrZero
    @NotNull(message = "Invalid Input")
    private Long careerHours;

}
