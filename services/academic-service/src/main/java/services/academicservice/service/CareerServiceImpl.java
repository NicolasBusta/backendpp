package services.academicservice.service;

import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import services.academicservice.dto.CareerDtoGet;
import services.academicservice.dto.CareerDtoGetTwo;
import services.academicservice.dto.CareerDtoPost;
import services.academicservice.entity.Career;
import services.academicservice.repository.CareerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CareerServiceImpl {

    private CareerRepository careerRepository;

    public CareerServiceImpl(CareerRepository careerRepository) {
        this.careerRepository = careerRepository;
    }

    public List<CareerDtoGet> fetchAllCareers(Integer pageNo, Integer pageSize, String direction, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.Direction.fromString(direction), sortBy);
        Page<Career> careers = careerRepository.findAll(paging);
        List<CareerDtoGet> careerDtoGet=careers.stream().map(CareerDtoGet::new).collect(Collectors.toList());
        return careerDtoGet;
    }

    public List<CareerDtoGetTwo> fetchAllCareersDto(Integer pageNo, Integer pageSize, String sortBy, String direction) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.Direction.fromString(direction), sortBy);
        Page<Career> careerList = careerRepository.findAll(paging);
        List<CareerDtoGetTwo> careerDtoGetTwoList = new ArrayList<>();
        for (Career career : careerList) {
            careerDtoGetTwoList.add(new CareerDtoGetTwo(career, career.getCareerBook()));
        }
        return careerDtoGetTwoList;
    }

    public CareerDtoGet fetchCareerById(Long id) {
          Career career = careerRepository.findById(id)
                  .orElseThrow(() -> new ObjectNotFoundException(id, "Career"));
          CareerDtoGet careerDtoGet = new CareerDtoGet(career);
          return careerDtoGet;
    }

    public ResponseEntity<String> createCareer(CareerDtoPost careerDtoPost) {
        Career career = new Career(careerDtoPost);
        careerRepository.save(career);
        return new ResponseEntity<String>("Career created successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteCareerById(Long id) {
        Career career = careerRepository.findById(id)
                        .orElseThrow(() -> new ObjectNotFoundException(id, "Career"));
        careerRepository.delete(career);
        return new ResponseEntity<String>("Career deleted successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> updateCareer(Long id, CareerDtoPost careerDtoPost) {
        Career career = careerRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "Career"));
        career.setDescription(careerDtoPost.getDescription());
        careerRepository.save(career);
        return new ResponseEntity<String>("Career updated successfully", HttpStatus.OK);
    }

}
