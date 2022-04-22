package services.academicservice.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
public class CareerDtoPost {

    public final static String REGEX = "^[A-Za-záéíóúÁÉÍÓÚ]+( [A-Za-záéíóúÁÉÍÓÚ]+)*$";

    @Pattern(regexp=REGEX,message = "Invalid Input")
    private String description;

    @Pattern(regexp=REGEX,message = "Invalid Input")
    private String legal_description;

    private Boolean status;

    @Pattern(regexp=REGEX,message = "Invalid Input")
    private String code;

    @Positive
    @NotNull(message = "Invalid Input")
    private Short career_type;

    @PositiveOrZero
    @NotNull(message = "Invalid Input")
    private Long career_credits;

    @PositiveOrZero
    @NotNull(message = "Invalid Input")
    private Long career_hours;
}
