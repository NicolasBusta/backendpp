package services.academicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import services.academicservice.entity.Degree;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Long> {}



