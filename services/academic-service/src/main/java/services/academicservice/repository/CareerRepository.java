package services.academicservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import services.academicservice.entity.Career;

import java.util.List;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {

    @Query(
            "SELECT ac " +
                    "FROM Career ac " +
                    "WHERE ac.description = :description " +
                    "OR ac.legalDescription = :legalDescription " +
                    "OR ac.code = :code"
    )
    List<Career> findAllCareersBy(
            @Param("description") String description,
            @Param("legalDescription") String legalDescription,
            @Param("code") String code);

    @Query(
            "SELECT ac " +
                    "FROM Career ac " +
                    "WHERE ac.id <> :id " +
                    "AND (ac.description = :description " +
                    "OR ac.legalDescription = :legalDescription " +
                    "OR ac.code = :code)"
    )
    List<Career> findAllCareersBy(
            @Param("id") Long id,
            @Param("description") String description,
            @Param("legalDescription") String legalDescription,
            @Param("code") String code);

}
