package services.academicservice.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import services.academicservice.dto.SubjectDTOGet;
import services.academicservice.dto.SubjectDTOPost;
import services.academicservice.errorHandler.GenericErrorResponse;
import services.academicservice.service.SubjectService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @ApiOperation(value = "Retorna todas las asignaturas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericErrorResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericErrorResponse.class)})
    @GetMapping
    public List<SubjectDTOGet> fetchSubjects() {
        return subjectService.fetchAllSubjects();
    }

    @ApiOperation(value = "Crea una nueva asignatura")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericErrorResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericErrorResponse.class),
            @ApiResponse(code = 409, message = "Conflict")})
    @PostMapping
    public ResponseEntity<String> createSubject(
            @ApiParam(name = "DTO", value = "Datos de asignatura", required = true) @Valid @RequestBody SubjectDTOPost dto) {
        return subjectService.createSubject(dto);
    }

}
