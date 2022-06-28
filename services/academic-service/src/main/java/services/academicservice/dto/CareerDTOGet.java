package services.academicservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CareerDTOGet {

    private Long id;
    private String description;
    private Boolean status;
    private String code;
    private String careerType;
    
}
