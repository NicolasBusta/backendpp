package services.academicservice.service;

import services.academicservice.dto.TermDTOGet;

import java.util.List;

public interface TermService {

    List<TermDTOGet> fetchAllTerms();

    List<String> fetchAllTermsDescription();

}
