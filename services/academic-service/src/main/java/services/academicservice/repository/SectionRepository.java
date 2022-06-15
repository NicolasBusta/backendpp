package services.academicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import services.academicservice.entity.Section;

import java.util.List;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

    @Query(
            "SELECT se " +
                    "FROM Section se " +
                    "WHERE se.sectionName = :sectionName "
    )
    List<Section> findAllSectionsBy(
            @Param("sectionName") String sectionName);

}
