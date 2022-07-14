package services.academicservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ACADEMIC_SECTIONS", schema = "academic")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SECTION_NAME")
    private String sectionName;

    @ManyToOne
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;

    @Column(name = "LMS_TYPE")
    private Short lmsType;

    @Column(name = "LMS_SECTION_ID")
    private Long lmsSectionId;

    @ManyToOne
    @JoinColumn(name = "TERM_ID")
    private Term term;

    @Column(name = "MODALITY_TYPE")
    private Short modalityType;

    @Column(name = "SECTION_SIZE")
    private Short sectionSize;

    @Column(name = "SECTION_ENABLE")
    private Boolean sectionEnable;

    @Column(name = "SECTION_STATUS")
    private Boolean sectionStatus;

}
