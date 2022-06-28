package services.academicservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ACADEMIC_SUBJECTS_DEPARTMENTS", schema = "academic")
public class SubjectDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department departmentSubject;

    @OneToOne
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subjectDepartment;

}
