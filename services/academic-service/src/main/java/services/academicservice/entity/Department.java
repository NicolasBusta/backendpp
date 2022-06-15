package services.academicservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ACADEMIC_DEPARTMENTS", schema = "academic")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DEPARTMENT_CODE")
    private String departmentCode;

    @Column(name = "DEPARTMENT_DESCRIPTION")
    private String departmentDescription;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private Set<SubjectDepartment> subjectDepartments;

}
