package services.academicservice.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import services.academicservice.dto.SubjectDtoGet;
import services.academicservice.dto.SubjectDtoPost;
import services.academicservice.errorHandler.GenericErrorResponse;
import services.academicservice.service.SubjectServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private SubjectServiceImpl subjectService;

    @Autowired
    public SubjectController(SubjectServiceImpl subjectService) {
        this.subjectService = subjectService;
    }

    @ApiOperation(value = "Retorna todos los términos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericErrorResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericErrorResponse.class)})
    @GetMapping
    public List<SubjectDtoGet> fetchAllSubjects() {
        return subjectService.fetchAllSubjects();
    }

    @ApiOperation(value = "Crea una nueva asignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericErrorResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericErrorResponse.class),
            @ApiResponse(code = 409, message = "Conflict")})
    @PostMapping
    public ResponseEntity<String> createCareer(
            @ApiParam(name = "DTO", value = "Datos de asignatura", required = true) @Valid @RequestBody SubjectDtoPost dto) {
        return subjectService.createSubject(dto);
    }

}
