package services.academicservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CareerDtoGet {

    private Long id;
    private String description;
    private Boolean status;
    private String code;
    private String careerType;
    
}
