package services.academicservice.service;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import services.academicservice.converter.DegreeConverter;
import services.academicservice.dto.DegreeDTOGet;
import services.academicservice.dto.DegreeDTOPost;
import services.academicservice.entity.Degree;
import services.academicservice.repository.DegreeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DegreeServiceImpl implements DegreeService {

	DegreeRepository degreeRepository;
	DegreeConverter degreeConverter;

	@Autowired
	public DegreeServiceImpl(DegreeRepository degreeRepository) {
		this.degreeRepository = degreeRepository;
		this.degreeConverter = new DegreeConverter();
	}
	
	public List<DegreeDTOGet> fetchDegrees() {
		List<Degree> degreeList = degreeRepository.findAll();
		List<DegreeDTOGet> dtoList = new ArrayList<>();
		for (Degree degree : degreeList) {
			DegreeDTOGet dto = degreeConverter.entityToDTO(degree);
			dtoList.add(dto);
		}
		return dtoList;
	}

	public DegreeDTOGet fetchDegree(Long id) {
		Degree degree = degreeRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException(id, "Degree"));

		return degreeConverter.entityToDTO(degree);
	}
	
	public ResponseEntity<String> createDegree(DegreeDTOPost dto) {
		Degree degree = degreeConverter.dtoToEntity(dto);
		degreeRepository.save(degree);
		return new ResponseEntity<>("Degree created successfully", HttpStatus.CREATED);
	}
	
	public ResponseEntity<String> updateDegree(Long id, DegreeDTOPost dto) {
		Degree degree = degreeRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException(id, "Degree"));
		degree.setDescription(dto.getDescription());
		degree.setType(dto.getType());
        degreeRepository.save(degree);
		return new ResponseEntity<>("Degree updated successfully", HttpStatus.OK);
	}

	public ResponseEntity<String> deleteDegree(Long id) {
		degreeRepository.deleteById(id);
		return new ResponseEntity<>("Degree deleted successfully", HttpStatus.OK);
	}

}
