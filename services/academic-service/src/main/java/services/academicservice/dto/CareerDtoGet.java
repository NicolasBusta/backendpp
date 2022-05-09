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
    private Short career_type;

    public CareerDtoGet(Career career) {
        this.description = career.getDescription();
        this.status = career.getStatus();
        this.code = career.getCode();
        this.career_type = career.getCareer_type();
    }
}
