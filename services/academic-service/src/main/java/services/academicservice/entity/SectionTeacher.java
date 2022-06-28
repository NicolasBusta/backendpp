package services.academicservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ACADEMIC_SECTIONS_TEACHERS", schema = "academic")
public class SectionTeacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SECTION_ID")
    private Section section;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TEACHER_ID")
    private Teacher teacher;

    @Column(name = "LMS_ENROLLMENT_ID")
    private Long lms_enrollment_id;

    /*
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TEACHER_ID")
    private User user;
    */
}
