package services.academicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import services.academicservice.entity.SectionTeacher;

@Repository
public interface SectionTeacherRepository extends JpaRepository<SectionTeacher, Long> {}
