package services.academicservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import services.academicservice.dto.DegreeDtoGet;
import services.academicservice.dto.DegreeDtoPost;
import services.academicservice.entity.Degree;

public interface DegreeService {
	List<DegreeDtoGet> fetchAllDegrees();
	
	DegreeDtoGet fetchIdDegrees(Long id);
	
	ResponseEntity<String> degreeCreation(DegreeDtoPost degreeDtoPost);
	
	ResponseEntity<String> degreeDelete(Long id);
	
	ResponseEntity<String> degreeUpdate(Long id, DegreeDtoPost degreeDtoPost);
}
