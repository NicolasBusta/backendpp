package services.academicservice.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import services.academicservice.dto.SectionDtoGet;
import services.academicservice.errorHandler.GenericErrorResponse;
import services.academicservice.service.SectionServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {

    private SectionServiceImpl sectionService;

    @Autowired
    public SectionController(SectionServiceImpl sectionService) {
        this.sectionService = sectionService;
    }

    @ApiOperation(value = "Retorna todas las secciones")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericErrorResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericErrorResponse.class)})
    @GetMapping
    public List<SectionDtoGet> fetchAllSections(
    		@ApiParam(name = "pageNo", value = "Número de página", required = false)
                @RequestParam(defaultValue = "0") Integer pageNo,
    		@ApiParam(name = "pageSize", value = "Tamaño de página", required = false)
                @RequestParam(defaultValue = "20") Integer pageSize,
    		@ApiParam(name = "sortBy", value = "Campo de ordenamiento", required = false)
                @RequestParam(defaultValue = "id") String sortBy,
    		@ApiParam(name = "direction", value = "Dirección de ordenamiento", required = false)
                @RequestParam(defaultValue = "ASC") String direction) {
        return sectionService.fetchAllSections(pageNo, pageSize, sortBy, direction);
    }

    @ApiOperation(value = "Retorna una sección")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericErrorResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericErrorResponse.class)})
    @GetMapping("/{id}")
    public SectionDtoGet getSectionById(
    		@ApiParam(name = "id", value = "ID de la carrera", required = true) @PathVariable Long id) {
        return sectionService.fetchSectionById(id);
    }
}
