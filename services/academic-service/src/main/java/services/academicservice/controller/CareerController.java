package services.academicservice.controller;

import io.swagger.v3.oas.annotations.Parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import services.academicservice.dto.CareerDtoGet;
import services.academicservice.dto.CareerDtoGetTwo;
import services.academicservice.dto.CareerDtoPost;
import services.academicservice.service.CareerServiceImpl;
import services.academicservice.utils.ApiDelete;
import services.academicservice.utils.ApiGet;
import services.academicservice.utils.ApiPost;
import services.academicservice.utils.ApiPut;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/careers")
public class CareerController {

    private CareerServiceImpl careerService;

    @Autowired
    public CareerController(CareerServiceImpl careerService) {
        this.careerService = careerService;
    }

    @ApiGet
    public List<CareerDtoGetTwo> fetchAllCareersDto(
            @Parameter(description = "number of page shown") @RequestParam(defaultValue = "0") Integer pageNo,
            @Parameter(description = "number of careers display") @RequestParam(defaultValue = "20") Integer pageSize,
            @Parameter(description = "field to be sorted by") @RequestParam(defaultValue = "id") String sortBy,
            @Parameter(description = "direction of the sorting") @RequestParam(defaultValue = "ASC") String direction) {
        return careerService.fetchAllCareersDto(pageNo, pageSize, sortBy, direction);
    }

    @ApiGet("/{id}")
      public CareerDtoGet fetchCareerById(
            @Parameter(description = "id of career to be searched") @PathVariable(value = "id") Long id) {
          return careerService.fetchCareerById(id);
    }

    @ApiPost
    public ResponseEntity<String> createCareer(@Valid @RequestBody CareerDtoPost dto) {
        return careerService.createCareer(dto);
    }

    @ApiPut("/{id}")
    public ResponseEntity<String> updateCareer(
            @Parameter(description = "id of career to be searched") @PathVariable(value = "id") Long id,
            @Valid @RequestBody CareerDtoPost dto) {
        return careerService.updateCareer(id, dto);
    }

    @ApiDelete("/{id}")
    public ResponseEntity<String> deleteCareerById(
            @Parameter(description = "id of career to be searched") @PathVariable(value = "id") Long id) {
        return careerService.deleteCareerById(id);
    }

}