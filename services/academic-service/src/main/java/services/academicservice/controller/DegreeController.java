package services.academicservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import services.academicservice.dto.CareerDtoPost;
import services.academicservice.dto.DegreeDtoGet;
import services.academicservice.dto.DegreeDtoPost;
import services.academicservice.entity.Degree;
import services.academicservice.service.DegreeServiceImpl;



@RestController
@RequestMapping("/degree")
public class DegreeController {

	@Autowired
	DegreeServiceImpl degreeService; 
	
	@GetMapping("/all")
	public List<DegreeDtoGet> fetchAllDegrees(){
		return degreeService.fetchAllDegrees();
	}
	
	@GetMapping("/get/{id}")
    public DegreeDtoGet fetchIdDegrees(@PathVariable(value = "id") Long id){
        return degreeService.fetchIdDegrees(id);
    }
	
	@PostMapping("/save")
    public ResponseEntity<String> degreeCreation(@RequestBody DegreeDtoPost degreeDtoPost){
       return degreeService.degreeCreation(degreeDtoPost);
    }
	
	@DeleteMapping ("/delete/{id}")
	public ResponseEntity<String> degreeDelete(@PathVariable(value = "id") Long id){
		 return degreeService.degreeDelete(id);
	}
	
	@PutMapping("/{id}/update")
	public ResponseEntity<String> degreeUpdate(@PathVariable(value = "id") Long id, @RequestBody DegreeDtoPost degreeDtoPost){
	       return degreeService.degreeUpdate(degreeDtoPost, id );
	    }
	
}
