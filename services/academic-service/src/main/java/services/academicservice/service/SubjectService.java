package services.academicservice.service;

import java.util.List;
import services.academicservice.dto.SubjectDtoGet;

public interface SubjectService {
	
	List<SubjectDtoGet> fetchAllSubject();
	
}
