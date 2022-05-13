package services.academicservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import services.academicservice.entity.Career;
import services.academicservice.entity.CareerBook;

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
    private Long careerCredits;
    private Long careerHours;
    private Short book;

    public CareerDtoGetTwo(Career career, CareerBook careerBook) {
        this.id = career.getId();
        this.description = career.getDescription();
        this.status = career.getStatus();
        this.code = career.getCode();
        this.sapCode = career.getSapCode();
        this.careerCredits = career.getCareerCredits();
        this.careerHours = career.getCareerHours();
        this.book = careerBook.getBook();
    }

}