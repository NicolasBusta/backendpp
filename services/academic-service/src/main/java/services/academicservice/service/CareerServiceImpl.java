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
import services.academicservice.entity.CareerBook;
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

    /**
     *
     * @param pageNo page number to display
     * @param pageSize number of objects shown per page
     * @param direction ascendant or descendant
     * @param sortBy field to be ordered by
     * @return list of career objects
     */
    public List<CareerDtoGet> fetchAllCareers(Integer pageNo, Integer pageSize, String direction, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.Direction.fromString(direction), sortBy);
        Page<Career> careers = careerRepository.findAll(paging);
        List<CareerDtoGet> careerDtoGet=careers.stream().map(CareerDtoGet::new).collect(Collectors.toList());
        return careerDtoGet;
    }

    /**
     *
     * @param pageNo page number to display
     * @param pageSize number of objects shown per page
     * @param direction ascendant or descendant
     * @param sortBy field to be ordered by
     * @return list of career DTO objects
     */
    public List<CareerDtoGetTwo> fetchAllCareersDto(Integer pageNo, Integer pageSize, String sortBy, String direction) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.Direction.fromString(direction), sortBy);
        Page<Career> careerList = careerRepository.findAll(paging);
        List<CareerDtoGetTwo> careerDtoGetTwoList = new ArrayList<>();
        for (Career career : careerList) {
            careerDtoGetTwoList.add(new CareerDtoGetTwo(career, career.getCareerBook()));
        }
        return careerDtoGetTwoList;
    }

    /**
     *
     * @param id id of career to be searched
     * @return career object which id correlate with the request
     */
    public CareerDtoGet fetchCareerById(Long id) {
          Career career = careerRepository.findById(id)
                  .orElseThrow(() -> new ObjectNotFoundException(id, "Career"));
          CareerDtoGet careerDtoGet = new CareerDtoGet(career);
          return careerDtoGet;
    }

    /**
     *
     * @param dto DTO which contains specified fields for different tables
     * @return responseEntity object which contains a message and a http status
     */
    public ResponseEntity<String> createCareer(CareerDtoPost dto) {
        List<Career> careerList = careerRepository.findAll();
        for (Career item: careerList) {
            if (item.getDescription().equals(dto.getDescription())) {
                return new ResponseEntity<String>("Career already exists", HttpStatus.NOT_ACCEPTABLE);
            }
        }
        Career career = new Career(dto);
        careerRepository.save(career);
        return new ResponseEntity<String>("Career created successfully", HttpStatus.CREATED);
    }

    /**
     *
     * @param id id of career to be searched
     * @param dto DTO which contains specified fields for different tables
     * @return responseEntity object which contains a message and a http status
     */
    public ResponseEntity<String> updateCareer(Long id, CareerDtoPost dto) {
        List<Career> careerList = careerRepository.findAll();
        for (Career item: careerList) {
            if (item.getDescription().equals(dto.getDescription())) {
                return new ResponseEntity<String>("Career already exists", HttpStatus.NOT_ACCEPTABLE);
            }
        }
        Career updatedCareer = careerRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "Career"));
        CareerBook updatedCareerBook = updatedCareer.getCareerBook();
        updatedCareerBook.update(dto);
        updatedCareer.update(dto, updatedCareerBook);
        careerRepository.save(updatedCareer);
        return new ResponseEntity<String>("Career updated successfully", HttpStatus.OK);
    }

    /**
     *
     * @param id id of career to be searched
     * @return responseEntity object which contains a message and a http status
     */
    public ResponseEntity<String> deleteCareerById(Long id) {
        Career career = careerRepository.findById(id)
                        .orElseThrow(() -> new ObjectNotFoundException(id, "Career"));
        careerRepository.delete(career);
        return new ResponseEntity<String>("Career deleted successfully", HttpStatus.OK);
    }

}
