package services.academicservice.converter;

import services.academicservice.dto.CareerDtoGet;
import services.academicservice.dto.CareerDtoGetTwo;
import services.academicservice.dto.CareerDtoPost;
import services.academicservice.entity.Career;
import services.academicservice.entity.CareerBook;

public class CareerConverter {

    public CareerDtoGet entityToBasicDTO(Career career) {
        CareerDtoGet dto = new CareerDtoGet();
        dto.setDescription(career.getDescription());
        dto.setStatus(career.getStatus());
        dto.setCode(career.getCode());
        dto.setCareerType(career.getCareerType());

        return dto;
    }
    public CareerDtoGetTwo entityToDTO(Career career) {
        CareerDtoGetTwo dto = new CareerDtoGetTwo();
        dto.setId(career.getId());
        dto.setDescription(career.getDescription());
        dto.setLegalDescription(career.getLegalDescription());
        dto.setStatus(career.getStatus());
        dto.setCode(career.getCode());
        dto.setSapCode(career.getSapCode());
        dto.setCareerCredits(career.getCareerCredits());
        dto.setCareerHours(career.getCareerHours());
        dto.setBook(career.getCareerBook().getBook());

        return dto;
    }

    public Career dtoToEntity(CareerDtoPost dto) {
        Career career = new Career();
        career.setDescription(dto.getDescription());
        career.setLegalDescription(dto.getLegalDescription());
        career.setStatus(dto.getStatus());
        career.setCode(dto.getCode());
        career.setCareerType(dto.getCareerType());
        career.setCareerCredits(dto.getCareerCredits());
        career.setCareerHours(dto.getCareerHours());
        career.setCareerBook(new CareerBook());
        career.getCareerBook().setCareer(career);
        career.getCareerBook().setBook(dto.getBook());
        career.getCareerBook().setInvoice(dto.getInvoice());

        return career;
    }

}
