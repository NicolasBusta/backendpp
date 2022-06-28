package services.academicservice.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import services.academicservice.dto.SectionDTOGet;
import services.academicservice.dto.SectionDTOPost;
import services.academicservice.errorHandler.GenericErrorResponse;
import services.academicservice.service.SectionServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {

        private final SectionServiceImpl sectionService;

        @Autowired
        public SectionController(SectionServiceImpl sectionService) {
                this.sectionService = sectionService;
        }

        @ApiOperation(value = "Retorna todas las secciones")
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "Success"),
                        @ApiResponse(code = 400, message = "Bad Request", response = GenericErrorResponse.class),
                        @ApiResponse(code = 404, message = "Not found", response = GenericErrorResponse.class) })
        @GetMapping
        public List<SectionDTOGet> fetchSections(
                        @ApiParam(name = "pageNo", value = "Número de página") @RequestParam(defaultValue = "0") Integer pageNo,
                        @ApiParam(name = "pageSize", value = "Tamaño de página") @RequestParam(defaultValue = "20") Integer pageSize,
                        @ApiParam(name = "sortBy", value = "Campo de ordenamiento") @RequestParam(defaultValue = "id") String sortBy,
                        @ApiParam(name = "direction", value = "Dirección de ordenamiento") @RequestParam String direction) {
                return sectionService.fetchAllSections(pageNo, pageSize, sortBy, direction);
        }

        @ApiOperation(value = "Retorna una sección")
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "Success"),
                        @ApiResponse(code = 400, message = "Bad Request", response = GenericErrorResponse.class),
                        @ApiResponse(code = 404, message = "Not found", response = GenericErrorResponse.class) })
        @GetMapping("/{id}")
        public SectionDTOGet fetchSection(
                        @ApiParam(name = "id", value = "ID de la sección", required = true) @PathVariable Long id) {
                return sectionService.fetchSectionById(id);
        }

        @ApiOperation(value = "Crea una nueva sección")
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "Success"),
                        @ApiResponse(code = 400, message = "Bad Request", response = GenericErrorResponse.class),
                        @ApiResponse(code = 404, message = "Not found", response = GenericErrorResponse.class),
                        @ApiResponse(code = 409, message = "Conflict") })
        @PostMapping
        public ResponseEntity<String> createSection(
                        @ApiParam(name = "DTO", value = "Datos de sección", required = true) @Valid @RequestBody SectionDTOPost dto) {
                return sectionService.createSection(dto);
        }

        @ApiOperation(value = "Actualiza una sección")
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "Success"),
                        @ApiResponse(code = 400, message = "Bad Request", response = GenericErrorResponse.class),
                        @ApiResponse(code = 404, message = "Not found", response = GenericErrorResponse.class),
                        @ApiResponse(code = 409, message = "Conflict") })
        @PutMapping("/{id}")
        public ResponseEntity<String> updateSection(
                        @ApiParam(name = "id", value = "ID de la sección", required = true) @PathVariable(value = "id") Long id,
                        @ApiParam(name = "DTO", value = "Datos de sección", required = true) @Valid @RequestBody SectionDTOPost dto) {
                return sectionService.updateSection(id, dto);
        }

        @ApiOperation(value = "Elimina una sección")
        @ApiResponses(value = {
                        @ApiResponse(code = 200, message = "Success"),
                        @ApiResponse(code = 400, message = "Bad Request", response = GenericErrorResponse.class),
                        @ApiResponse(code = 404, message = "Not found", response = GenericErrorResponse.class) })
        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteSection(
                        @ApiParam(name = "id", value = "ID de la sección", required = true) @PathVariable(value = "id") Long id) {
                return sectionService.deleteSectionById(id);
        }

}
