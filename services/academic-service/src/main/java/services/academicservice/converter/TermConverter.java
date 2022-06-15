package services.academicservice.converter;

import services.academicservice.dto.TermDtoGet;
import services.academicservice.entity.Term;

public class TermConverter {

    public TermDtoGet entityToDTO(Term term) {
        TermDtoGet dto = new TermDtoGet();
        dto.setTermDescription(term.getTermDescription());

        return dto;
    }

}
