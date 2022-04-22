package services.academicservice.entity;

import lombok.*;
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

}
