package services.academicservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import services.academicservice.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query(
            "SELECT dp " +
                    "FROM Department dp " +
                    "WHERE dp.departmentName = :departmentName"
    )
    Department findDepartmentBy(@Param("departmentName") String departmentName);

}
