package services.academicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import services.academicservice.entity.SubjectDepartment;

@Repository
public interface SubjectDepartmentRepository extends JpaRepository<SubjectDepartment, Long> {

    /*
    @Query(
            "SELECT dp " +
                    "FROM SubjectDepartment dp " +
                    "WHERE dp.departmentSubject = :department " +
                    "AND dp.subjectDepartment = :subject"
    )
    List<SubjectDepartment> findSubjectDepartmentBy(
            @Param("subject") Long subjectId,
            @Param("department") Long departmentId);

     */

    boolean existsByDepartmentIdAndSubjectId(Long departmentId, Long subjectId);
    //boolean existsByDepartmentIdAndSubjectId(Department department, Subject subject);

}
