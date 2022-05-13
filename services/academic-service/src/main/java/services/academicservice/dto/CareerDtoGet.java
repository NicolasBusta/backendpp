package services.academicservice.dto;

import lombok.Getter;
import lombok.Setter;
import services.academicservice.entity.Career;

@Getter
@Setter
public class CareerDtoGet {

    private String description;
    private Boolean status;
    private String code;
    private Short careerType;

    public CareerDtoGet(Career career) {
        this.description = career.getDescription();
        this.status = career.getStatus();
        this.code = career.getCode();
        this.careerType = career.getCareerType();
    }
    
}
