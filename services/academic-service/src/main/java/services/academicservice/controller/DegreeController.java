package services.academicservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import services.academicservice.dto.DegreeDTOGet;
import services.academicservice.dto.DegreeDTOPost;
import services.academicservice.service.DegreeService;

import java.util.List;

@RestController
@RequestMapping("/degrees")
public class DegreeController {

	private final DegreeService degreeService;

	@Autowired
	public DegreeController(DegreeService degreeService) {
		this.degreeService = degreeService;
	}

	@GetMapping
	public List<DegreeDTOGet> fetchDegrees() {
		return degreeService.fetchDegrees();
	}
	
	@GetMapping("/{id}")
    public DegreeDTOGet fetchDegree(@PathVariable(value = "id") Long id) {
        return degreeService.fetchDegree(id);
    }
	
	@PostMapping
    public ResponseEntity<String> createDegree(@RequestBody DegreeDTOPost dto) {
       return degreeService.createDegree(dto);
    }

	@DeleteMapping ("/{id}")
	public ResponseEntity<String> deleteDegree(@PathVariable(value = "id") Long id) {
		 return degreeService.deleteDegree(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateDegree(@PathVariable(value = "id") Long id, @RequestBody DegreeDTOPost dto) {
	       return degreeService.updateDegree(id, dto);
	}
	
}

