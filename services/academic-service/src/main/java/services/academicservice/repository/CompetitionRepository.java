package services.academicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import services.academicservice.entity.Competition;

import java.util.List;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {

    @Query(
            "SELECT DISTINCT c.competitionName " +
                    "FROM Competition c"
    )
    List<String> getAllCompetitionsByName();

    @Query(
            "SELECT c " +
                    "FROM Competition c " +
                    "WHERE c.competitionName = :name"
    )
    List<Competition> findAllCompetitionsBy(
            @Param("name") String name);

}
