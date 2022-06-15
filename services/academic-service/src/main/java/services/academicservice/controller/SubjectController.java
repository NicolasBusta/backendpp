package services.academicservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.academicservice.dto.SubjectDtoGet;
import services.academicservice.service.SubjectServiceImpl;

@RestController
@RequestMapping("/subject")
public class SubjectController {

	@Autowired
	SubjectServiceImpl subjectService;
	
	@GetMapping("/all")
	public List<SubjectDtoGet> fetchAllSubject(){
	return subjectService.fetchAllSubject();
	}
}
