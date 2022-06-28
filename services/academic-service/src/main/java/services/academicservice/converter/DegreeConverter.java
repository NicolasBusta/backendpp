package services.academicservice.converter;

import services.academicservice.dto.DegreeDTOGet;
import services.academicservice.dto.DegreeDTOPost;
import services.academicservice.entity.Degree;

public class DegreeConverter {

    public Degree dtoToEntity(DegreeDTOPost dto) {
        Degree degree = new Degree();
        degree.setDescription(dto.getDescription());
        if (dto.getDescription().equals("Final")) {
            degree.setType((short) 12);
        }
        return degree;
    }

    public DegreeDTOGet entityToDTO(Degree degree) {
        DegreeDTOGet dto = new DegreeDTOGet();
        dto.setDescription(degree.getDescription());
        if (degree.getType() == 12) {
            dto.setType("Final");
        }
        return dto;
    }
}
