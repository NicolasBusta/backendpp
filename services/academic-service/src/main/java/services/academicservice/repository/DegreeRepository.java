package services.academicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import services.academicservice.entity.Career;
import services.academicservice.entity.Degree;

import java.util.List;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Long> {

    @Query(
            "SELECT de " +
                    "FROM Degree de " +
                    "WHERE de.description = :description OR de.alternativeName = :alternativeDescription"
    )
    List<Career> findAllDegreesBy(
            @Param("description") String description,
            @Param("alternativeDescription") String alternativeDescription);

    @Query(
            "SELECT de " +
                    "FROM Degree de " +
                    "WHERE de.id <> :id " +
                    "AND de.description = :description"
    )
    List<Career> findAllDegreesBy(
            @Param("id") Long id,
            @Param("description") String description);

}



