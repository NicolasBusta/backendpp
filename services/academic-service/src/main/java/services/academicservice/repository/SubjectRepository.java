package services.academicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import services.academicservice.entity.Career;
import services.academicservice.entity.Subject;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    @Query(
            "SELECT sj " +
                    "FROM Subject sj " +
                    "WHERE sj.subjectDescription = :subjectDescription"
    )
    Subject findSubjectBy(@Param("subjectDescription") String subjectDescription);

    @Query(
            "SELECT DISTINCT s.subjectDescription " +
                    "FROM Subject s"
    )
    List<String> getDistinctSubjectsByName();

    @Query(
            "SELECT su " +
                    "FROM Subject su " +
                    "WHERE su.subjectDescription = :subjectDescription " +
                    "OR su.subjectCode = :subjectCode"
    )
    List<Career> findAllSubjectsBy(
            @Param("subjectDescription") String subjectDescription,
            @Param("subjectCode") String subjectCode);

}
