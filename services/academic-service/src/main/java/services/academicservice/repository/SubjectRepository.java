package services.academicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import services.academicservice.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{

}
