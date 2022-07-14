package services.academicservice.converter;

import services.academicservice.dto.DegreeDTOGet;
import services.academicservice.dto.DegreeDTOPost;
import services.academicservice.entity.Degree;

public class DegreeConverter {

    public Degree dtoToEntity(DegreeDTOPost dto) {
        Degree degree = new Degree();
        degree.setDescription(dto.getDescription());
        if (dto.getType().equals("Final")) {
            degree.setType((short) 12);
        } else if (dto.getType().equals("Intermedio")){
            degree.setType((short) 11);
        }
        return degree;
    }

    public DegreeDTOGet entityToDTO(Degree degree) {
        DegreeDTOGet dto = new DegreeDTOGet();
        dto.setId(degree.getId());
        dto.setDescription(degree.getDescription());
        if (degree.getType() == 12) {
            dto.setType("Final");
        } else if (degree.getType() == 11) {
            dto.setType("Intermedio");
        }
        return dto;
    }
}
