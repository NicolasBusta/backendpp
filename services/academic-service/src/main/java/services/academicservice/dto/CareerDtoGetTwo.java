package services.academicservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CareerDtoGetTwo {

    private Long id;
    private String description;
    private String legalDescription;
    private Boolean status;
    private String code;
    private String sapCode;
    private long careerCredits;
    private Long careerHours;
    private Short book;

}