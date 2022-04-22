package services.academicservice.controller;

import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import services.academicservice.dto.CareerDtoGet;
import services.academicservice.dto.CareerDtoPost;
import services.academicservice.entity.Career;
import services.academicservice.service.CareerService;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Validated
@RequestMapping("/api/career")
public class CareerController {

    private CareerService careerService;
    private ModelMapper modelMapper;

    @Autowired
    public CareerController(CareerService careerService, ModelMapper modelMapper) {
        this.careerService = careerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public List<CareerDtoGet> getAllCareers() {
        return careerService.getAllCareers().stream().map(career -> modelMapper.map(career, CareerDtoGet.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CareerDtoGet> getCareerById(@PathVariable(value = "id") Long careerId) {
        Career career = careerService.getCareerById(careerId);
        CareerDtoGet careerResponse = modelMapper.map(career, CareerDtoGet.class);
        return ResponseEntity.ok().body(careerResponse);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCareer(@RequestBody @Valid CareerDtoPost careerDto) {
        Career careerRequest = modelMapper.map(careerDto, Career.class);
        Career career = careerService.createCareer(careerRequest);
        return new ResponseEntity<String>("Career created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCareer(@PathVariable(value = "id") Long careerId) {
        careerService.deleteCareer(careerId);
        return "Career deleted successfully";
    }

    @PutMapping("/update/{id}")
    public Career updateCareer(@PathVariable(value = "id") Long careerId,
                               @RequestBody @Valid Career careerDetails) throws ObjectNotFoundException {
        Career career = careerService.updateCareer(careerId, careerDetails);
        return career;
    }
}
