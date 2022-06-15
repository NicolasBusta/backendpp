package services.academicservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ACADEMIC_SUBJECTS", schema = "academic")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SUBJECT_CODE")
    private String subjectCode;

    @Column(name = "SUBJECT_DESCRIPTION")
    private String subjectDescription;

    @Column(name = "SUBJECT_STATUS")
    private Boolean subjectStatus;

    @Column(name = "SUBJECT_DURATION")
    private Short subjectDuration;

    @Column(name = "SUBJECT_TYPE")
    private Short subjectType;

    @Column(name = "SUBJECT_HOURS")
    private Long subjectHours;

    @Column(name = "SUBJECT_CREDITS")
    private Long subjectCredits;

    @Column(name = "EXAM_TYPE")
    private Short examType;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Section> sections;

    /*
    @OneToOne(mappedBy = "subject", cascade = CascadeType.ALL)
    private SubjectCompetition subjectCompetition;
    */

}
