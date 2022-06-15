package services.academicservice.converter;

import services.academicservice.dto.CareerDtoGet;
import services.academicservice.dto.CareerDtoGetTwo;
import services.academicservice.dto.CareerDtoPost;
import services.academicservice.entity.Career;
import services.academicservice.entity.CareerBook;

public class CareerConverter {

    public CareerDtoGet entityToBasicDTO(Career career) {
        CareerDtoGet dto = new CareerDtoGet();
        dto.setId(career.getId());
        dto.setDescription(career.getDescription());
        dto.setStatus(career.getStatus());
        dto.setCode(career.getCode());
        Short careerType = career.getCareerType();
        if (careerType == 1) {
            dto.setCareerType("Profesional");
        } else if (careerType == 2) {
            dto.setCareerType("Técnico de Nivel Superior");
        } else if (careerType == 3) {
            dto.setCareerType("Programa de Continuidad de Estudio");
        }

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
        if (dto.getCareerType().equals("Profesional")) {
            career.setCareerType((short) 1);
        } else if (dto.getCareerType().equals("Técnico de Nivel Superior")) {
            career.setCareerType((short) 2);
        } else if (dto.getCareerType().equals("Programa de Continuidad de Estudio")) {
            career.setCareerType((short) 3);
        }
        career.setCareerCredits(dto.getCareerCredits());
        career.setCareerHours(dto.getCareerHours());
        career.setCareerBook(new CareerBook());
        career.getCareerBook().setCareer(career);
        career.getCareerBook().setBook(dto.getBook());
        career.getCareerBook().setInvoice(dto.getInvoice());

        return career;
    }

}
