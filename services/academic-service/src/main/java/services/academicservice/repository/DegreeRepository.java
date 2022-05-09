package services.academicservice.repository;
import services.academicservice.entity.Degree;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Long>{
	/*Degree findByDescripcion(String descripcion);*/
}



