package services.academicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import services.academicservice.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query("SELECT th " +
            "FROM Teacher th " +
            "WHERE th.userId = :userId")
    Teacher findByUserId(@Param("userId") Long userId);

}
