package services.academicservice.repository;

import org.springframework.stereotype.Repository;
import services.academicservice.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {

}
