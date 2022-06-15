package services.academicservice.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.academicservice.dto.SubjectDtoGet;
import services.academicservice.entity.Subject;
import services.academicservice.repository.SubjectRepository;

@Service
public class SubjectServiceImpl {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	public List<SubjectDtoGet> fetchAllSubject(){
		
		List<Subject> subjectAll = subjectRepository.findAll();
		List<SubjectDtoGet> subjectAllDto = subjectAll.stream().map(SubjectDtoGet::new).collect(Collectors.toList());
		return subjectAllDto;
		
	}
}
