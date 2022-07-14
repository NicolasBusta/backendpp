package services.academicservice.service;

import org.springframework.http.ResponseEntity;

import services.academicservice.dto.CareerDTOGet;
import services.academicservice.dto.CareerDTOPost;

import java.util.List;

public interface CareerService {

    List<CareerDTOGet> fetchAllCareer();

    List<CareerDTOGet> fetchAllCareers(Integer pageNo, Integer pageSize, String sortBy, String direction);

    CareerDTOGet fetchCareerById(Long id);

    ResponseEntity<String> createCareer(CareerDTOPost dto);

    ResponseEntity<String> updateCareer(Long id, CareerDTOPost dto);

    ResponseEntity<String> deleteCareerById(Long id);

}
