package services.academicservice.dto;

import lombok.Data;

@Data
public class CareerDtoGet {

    private String description;
    private Boolean status;
    private String code;
    private Short career_type;

}
