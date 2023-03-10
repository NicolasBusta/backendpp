package services.academicservice.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.academicservice.dto.TermDTOGet;
import services.academicservice.errorHandler.GenericErrorResponse;
import services.academicservice.service.TermService;

import java.util.List;

@RestController
@RequestMapping("/terms")
public class TermController {

    private final TermService termService;

    @Autowired
    public TermController(TermService termService) {
        this.termService = termService;
    }

    @ApiOperation(value = "Retorna todos los términos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericErrorResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericErrorResponse.class)})
    @GetMapping
    public List<TermDTOGet> fetchTerms() {
        return termService.fetchAllTerms();
    }

    @ApiOperation(value = "Retornar solo la descripción de todas los términos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericErrorResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericErrorResponse.class)})
    @GetMapping("/description")
    public List<String> fetchTermsDescription() {
        return termService.fetchAllTermsDescription();
    }

}
