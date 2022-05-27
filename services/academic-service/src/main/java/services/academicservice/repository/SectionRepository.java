package services.academicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import services.academicservice.entity.Section;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

}
