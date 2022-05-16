package services.academicservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import services.academicservice.dto.CareerDtoGet;
import services.academicservice.dto.CareerDtoGetTwo;
import services.academicservice.dto.CareerDtoPost;
import services.academicservice.service.CareerServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/career")
public class CareerController {

    private CareerServiceImpl careerService;

    @Autowired
    public CareerController(CareerServiceImpl careerService) {
        this.careerService = careerService;
    }

    @Operation(summary = "Get all careers")
    @ApiResponse(responseCode = "200", description = "Careers found")
    @GetMapping("/all")
    public List<CareerDtoGet> fetchAllCareers(
            @Parameter(description = "number of page shown") @RequestParam(defaultValue = "0") Integer pageNo,
            @Parameter(description = "number of careers display") @RequestParam(defaultValue = "20") Integer pageSize,
            @Parameter(description = "field to be sorted by") @RequestParam(defaultValue = "id") String sortBy,
            @Parameter(description = "direction of the sorting") @RequestParam(defaultValue = "ASC") String direction) {
        return careerService.fetchAllCareers(pageNo, pageSize, direction, sortBy);
    }

    @Operation(summary = "Get all careers with more information")
    @ApiResponse(responseCode = "200", description = "Careers found")
    @GetMapping("/dto/all")
    public List<CareerDtoGetTwo> fetchAllCareersDto(
            @Parameter(description = "number of page shown") @RequestParam(defaultValue = "0") Integer pageNo,
            @Parameter(description = "number of careers display") @RequestParam(defaultValue = "20") Integer pageSize,
            @Parameter(description = "field to be sorted by") @RequestParam(defaultValue = "id") String sortBy,
            @Parameter(description = "direction of the sorting") @RequestParam(defaultValue = "ASC") String direction) {
        return careerService.fetchAllCareersDto(pageNo, pageSize, sortBy, direction);
    }

    @Operation(summary = "Get a career by its id")
    @ApiResponse(responseCode = "200", description = "Career found")
    @GetMapping("/get/{id}")
      public CareerDtoGet fetchCareerById(
            @Parameter(description = "id of career to be searched") @PathVariable(value = "id") Long id) {
          return careerService.fetchCareerById(id);
    }

    @Operation(summary = "Create a new career")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Career created successfully"),
            @ApiResponse(responseCode = "406", description = "Career already exists")
    })
    @PostMapping("/create")
    public ResponseEntity<String> createCareer(@RequestBody CareerDtoPost dto) {
        return careerService.createCareer(dto);
    }

    @Operation(summary = "Update a career by its id and new field values")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Career updated successfully"),
            @ApiResponse(responseCode = "406", description = "Career already exists")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCareer(
            @Parameter(description = "id of career to be searched") @PathVariable(value = "id") Long id,
            @RequestBody CareerDtoPost dto) {
        return careerService.updateCareer(id, dto);
    }

    @Operation(summary = "Delete a career by its id")
    @ApiResponse(responseCode = "200", description = "Career deleted successfully")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCareerById(
            @Parameter(description = "id of career to be searched") @PathVariable(value = "id") Long id) {
        return careerService.deleteCareerById(id);
    }

}