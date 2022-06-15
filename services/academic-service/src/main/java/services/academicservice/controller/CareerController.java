package services.academicservice.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import services.academicservice.dto.CareerDtoGet;
import services.academicservice.dto.CareerDtoGetTwo;
import services.academicservice.dto.CareerDtoPost;
import services.academicservice.errorHandler.GenericErrorResponse;
import services.academicservice.service.CareerServiceImpl;

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
    
    @ApiOperation(value = "Retorna todas las carreras")
    @ApiResponses(value = {
    		@ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericErrorResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericErrorResponse.class)})
    @GetMapping
    public List<CareerDtoGetTwo> fetchAllCareersDto(
    		@ApiParam(name = "pageNo", value = "Número de página", required = false)
                @RequestParam(defaultValue = "0") Integer pageNo,
    		@ApiParam(name = "pageSize", value = "Tamaño de página", required = false)
                @RequestParam(defaultValue = "20") Integer pageSize,
    		@ApiParam(name = "sortBy", value = "Campo de ordenamiento", required = false)
                @RequestParam(defaultValue = "id") String sortBy,
    		@ApiParam(name = "direction", value = "Dirección de ordenamiento", required = false)
                @RequestParam(defaultValue = "asc") String direction) {
        return careerService.fetchAllCareersDto(pageNo, pageSize, sortBy, direction);
    }

    @ApiOperation(value = "Retorna una carrera")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericErrorResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericErrorResponse.class)})
    @GetMapping("/{id}")
      public CareerDtoGet fetchCareerById(
    		  @ApiParam(name = "id", value = "ID de la carrera", required = true) @PathVariable(value = "id") Long id) {
          return careerService.fetchCareerById(id);
    }

    @ApiOperation(value = "Crea una nueva carrera")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericErrorResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericErrorResponse.class),
            @ApiResponse(code = 409, message = "Conflict")})
    @PostMapping
    public ResponseEntity<String> createCareer(
            @ApiParam(name = "DTO", value = "Datos de carrera", required = true) @Valid @RequestBody CareerDtoPost dto) {
        return careerService.createCareer(dto);
    }

    @ApiOperation(value = "Actualiza una carrera")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericErrorResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericErrorResponse.class),
            @ApiResponse(code = 409, message = "Conflict")})
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCareer(
    		@ApiParam(name = "id", value = "ID de la carrera", required = true) @PathVariable(value = "id") Long id,
            @ApiParam(name = "DTO", value = "Datos de carrera", required = true) @Valid @RequestBody CareerDtoPost dto) {
        return careerService.updateCareer(id, dto);
    }

    @ApiOperation(value = "Elimina una carrera")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericErrorResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericErrorResponse.class)})
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCareerById(
    		@ApiParam(name = "id", value = "ID de la carrera", required = true) @PathVariable(value = "id") Long id) {
        return careerService.deleteCareerById(id);
    }

}