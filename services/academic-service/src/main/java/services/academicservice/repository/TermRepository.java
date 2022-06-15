package services.academicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import services.academicservice.entity.Term;

public interface TermRepository extends JpaRepository<Term, Long> {

    @Query(
            "SELECT te " +
                    "FROM Term te " +
                    "WHERE te.termDescription = :termDescription"
    )
    Term findTermBy(
            @Param("termDescription") String termDescription);

}
