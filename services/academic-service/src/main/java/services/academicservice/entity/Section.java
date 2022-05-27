package services.academicservice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ACADEMIC_SECTIONS", schema = "academic")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "SECTION_NAME")
    private String sectionName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SUBJECT_ID")
    @JsonManagedReference
    private Subject subject;

    @Column(name = "LMS_TYPE")
    private Short lmsType;

    @Column(name = "LMS_SECTION_ID")
    private Long lmsSectionId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TERM_ID")
    @JsonManagedReference
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
