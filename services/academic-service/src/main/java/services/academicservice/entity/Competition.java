package services.academicservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ACADEMIC_COMPETITIONS", schema = "academic")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "COMPETITION_NAME")
    private String competitionName;

    @Column(name = "COMPETITION_DESCRIPTION")
    private String competitionDescription;

    @OneToMany(mappedBy = "competition")
    private Set<SubjectCompetition> subjectCompetitions;

}
