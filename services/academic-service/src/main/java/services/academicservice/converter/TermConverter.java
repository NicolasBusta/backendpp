package services.academicservice.converter;

import services.academicservice.dto.TermDTOGet;
import services.academicservice.entity.Term;

public class TermConverter {

    public TermDTOGet entityToDTO(Term term) {
        TermDTOGet dto = new TermDTOGet();
        dto.setTermDescription(term.getTermDescription());

        return dto;
    }

}
