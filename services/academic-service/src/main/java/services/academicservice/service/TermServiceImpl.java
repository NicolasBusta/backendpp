package services.academicservice.service;

import org.springframework.stereotype.Service;

import services.academicservice.converter.TermConverter;
import services.academicservice.dto.TermDTOGet;
import services.academicservice.entity.Term;
import services.academicservice.repository.TermRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TermServiceImpl {

    private TermRepository termRepository;
    private TermConverter termConverter;

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

}
