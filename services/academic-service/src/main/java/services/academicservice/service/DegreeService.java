package services.academicservice.service;

import org.springframework.http.ResponseEntity;

import services.academicservice.dto.DegreeDTOGet;
import services.academicservice.dto.DegreeDTOPost;

import java.util.List;

public interface DegreeService {

	List<DegreeDTOGet> fetchDegrees();
	
	DegreeDTOGet fetchDegree(Long id);
	
	ResponseEntity<String> createDegree(DegreeDTOPost dto);

	ResponseEntity<String> updateDegree(Long id, DegreeDTOPost dto);

	ResponseEntity<String> deleteDegree(Long id);

}
