package services.academicservice.service;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.extern.slf4j.Slf4j;
import services.academicservice.dto.DegreeDtoGet;
import services.academicservice.dto.DegreeDtoPost;
import services.academicservice.entity.Degree;
import services.academicservice.repository.DegreeRepository;


@Service
/*@Slf4j*/
public class DegreeServiceImpl {
	@Autowired
	DegreeRepository degreeRepository;
	
	public List<DegreeDtoGet> fetchAllDegrees(){
		List<Degree> degreeAll = degreeRepository.findAll();
		List<DegreeDtoGet> degreeAllDto = degreeAll.stream().map(DegreeDtoGet::new).collect(Collectors.toList());
		return degreeAllDto;
	}

	public DegreeDtoGet fetchIdDegrees(Long id) {
		Degree buscarPorId = degreeRepository.findById(id).orElseThrow(null);
		DegreeDtoGet degreeIdDto = new DegreeDtoGet(buscarPorId);
		return degreeIdDto;
	}
	
	public ResponseEntity<String> degreeCreation(DegreeDtoPost degreeDtoPost) {
		
		Degree nuevoDegree = new Degree(degreeDtoPost);
		degreeRepository.save(nuevoDegree);
		return new ResponseEntity<String>("Degree create successfully", HttpStatus.OK);
	}
	
	public ResponseEntity<String> degreeDelete (Long id){
		degreeRepository.deleteById(id);
		return new ResponseEntity<String>("Degree delete successfully", HttpStatus.OK);
	}
	
	public ResponseEntity<String> degreeUpdate (DegreeDtoPost degreeDtoPost, Long id){
		Degree updateDegree = degreeRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "Degree"));
		updateDegree.setDescripcion(degreeDtoPost.getDescripcion());
		updateDegree.setTipo(degreeDtoPost.getTipo());
        degreeRepository.save(updateDegree);
		return new ResponseEntity<String>("The Degree was updated", HttpStatus.OK);
	}

}
