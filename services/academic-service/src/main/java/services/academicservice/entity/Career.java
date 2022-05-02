package services.academicservice.entity;

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
    @Column(name="ID")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "LEGAL_DESCRIPTION")
    private String legal_description;

    @Column(name = "STATUS")
    private Boolean status;

    @Column(name = "CODE")
    private String code;

    @Column(name = "SAP_CODE")
    private String sap_code;

    @Column(name = "CAREER_TYPE")
    private Short career_type;

    @Column(name = "CAREER_CREDITS")
    private Long career_credits;

    @Column(name = "CAREER_HOURS")
    private Long career_hours;

    @Column(name = "INTERMEDIATE_CAREER")
    private Long intermediate_career;

    public Career(CareerDtoPost careerDtoPost) {
        setDescription(careerDtoPost.getDescription());
        setLegal_description(careerDtoPost.getLegal_description());
        setStatus(careerDtoPost.getStatus());
        setCode(careerDtoPost.getCode());
        setCareer_type(careerDtoPost.getCareer_type());
        setCareer_credits(careerDtoPost.getCareer_credits());
        setCareer_hours(careerDtoPost.getCareer_hours());
    }
}
