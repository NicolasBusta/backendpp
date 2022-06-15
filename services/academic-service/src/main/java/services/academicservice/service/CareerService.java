package services.academicservice.service;

import org.springframework.http.ResponseEntity;

import services.academicservice.dto.CareerDtoGet;
import services.academicservice.dto.CareerDtoGetTwo;
import services.academicservice.dto.CareerDtoPost;

import java.util.List;

public interface CareerService {

    List<CareerDtoGet> fetchAllCareers(Integer pageNo, Integer pageSize, String sortBy, String direction);

    List<CareerDtoGetTwo> fetchAllCareersDto(Integer pageNo, Integer pageSize, String sortBy, String direction);

    CareerDtoGet fetchCareerById(Long id);

    ResponseEntity<String> createCareer(CareerDtoPost dto);

    ResponseEntity<String> updateCareer(Long id, CareerDtoPost dto);

    ResponseEntity<String> deleteCareerById(Long id);

}
