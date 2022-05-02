package services.academicservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import services.academicservice.dto.CareerDtoGet;
import services.academicservice.dto.CareerDtoPost;
import services.academicservice.service.CareerServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/career")
public class CareerController {

    private CareerServiceImpl careerService;

    @Autowired
    public CareerController(CareerServiceImpl careerService) {
        this.careerService = careerService;
    }

    @GetMapping("/all")
    public List<CareerDtoGet> fetchAllCareers(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "ASC") String direction) {
        return careerService.fetchAllCareers(pageNo, pageSize, direction, sortBy);
    }

    @GetMapping("/get/{id}")
    public CareerDtoGet fetchCareerById(@PathVariable(value = "id") Long id) {
        return careerService.fetchCareerById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCareer(@Valid @RequestBody CareerDtoPost careerDtoPost) {
        return careerService.createCareer(careerDtoPost);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCareerById(@PathVariable(value = "id") Long id) {
        return careerService.deleteCareerById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCareer(@PathVariable(value = "id") Long id,
                                               @Valid @RequestBody CareerDtoPost careerDtoPost) {
        return careerService.updateCareer(id, careerDtoPost);
    }

}
