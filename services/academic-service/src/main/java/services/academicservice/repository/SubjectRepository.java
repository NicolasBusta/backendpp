package services.academicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import services.academicservice.entity.Subject;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query(
            "SELECT su " +
                    "FROM Subject su " +
                    "WHERE su.subjectDescription = :subjectDescription"
    )
    Subject findSubjectBy(@Param("subjectDescription") String subjectDescription);


    @Query(
            "SELECT DISTINCT s.subjectDescription " +
                    "FROM Subject s"
    )
    List<String> getDistinctSubjectsByName();


    @Query(
            "SELECT DISTINCT su " +
                    "FROM Subject su"
    )
    List<Subject> getDistinctSubjects();

    @Query(
            "SELECT su " +
                    "FROM Subject su " +
                    "WHERE su.subjectDescription = :subjectDescription " +
                    "OR su.subjectCode = :subjectCode"
    )
    List<Subject> findAllSubjectsBy(
            @Param("subjectDescription") String subjectDescription,
            @Param("subjectCode") String subjectCode);

}
