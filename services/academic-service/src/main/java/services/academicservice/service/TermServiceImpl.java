package services.academicservice.service;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.GetMapping;
import services.academicservice.converter.TermConverter;
import services.academicservice.dto.TermDTOGet;
import services.academicservice.entity.Term;
import services.academicservice.errorHandler.GenericErrorResponse;
import services.academicservice.repository.TermRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TermServiceImpl implements TermService {

    private final TermRepository termRepository;
    private final TermConverter termConverter;

    @Autowired
    public TermServiceImpl(TermRepository termRepository) {
        this.termRepository = termRepository;
        this.termConverter = new TermConverter();
    }

    public List<TermDTOGet> fetchAllTerms() {
        List<Term> termList = termRepository.findAll();
        List<TermDTOGet> dtoList = new ArrayList<>();
        for (Term term : termList) {
            dtoList.add(termConverter.entityToDTO(term));
        }
        return dtoList;
    }

    @ApiOperation(value = "Retornar solo la descripción de todas las asignaturas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request", response = GenericErrorResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GenericErrorResponse.class)})
    @GetMapping("/description")
    public List<String> fetchAllTermsDescription() {
        return termRepository.getDistinctTermByName();
    }

}
