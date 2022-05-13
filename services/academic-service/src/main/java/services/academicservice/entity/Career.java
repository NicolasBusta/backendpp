package services.academicservice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import services.academicservice.dto.CareerDtoPost;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACADEMIC_CAREERS", schema = "academic")
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "LEGAL_DESCRIPTION")
    private String legalDescription;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "CODE")
    private String code;

    @Column(name = "SAP_CODE")
    private String sapCode;

    @Column(name = "CAREER_TYPE")
    private Short careerType;

    @Column(name = "CAREER_CREDITS")
    private Long careerCredits;

    @Column(name = "CAREER_HOURS")
    private Long careerHours;

    @Column(name = "INTERMEDIATE_CAREER")
    private Long intermediateCareer;

    @OneToOne(mappedBy = "career")
    @JsonManagedReference
    private CareerBook careerBook;

    public Career(CareerDtoPost careerDtoPost) {
        this.description = careerDtoPost.getDescription();
        this.legalDescription = careerDtoPost.getLegalDescription();
        this.status = careerDtoPost.getStatus();
        this.code = careerDtoPost.getCode();
        this.careerType = careerDtoPost.getCareerType();
        this.careerCredits = careerDtoPost.getCareerCredits();
        this.careerHours = careerDtoPost.getCareerHours();
    }

    public CareerBook getCareerBook() {
        return careerBook;
    }
}
