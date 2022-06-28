package services.academicservice.converter;

import services.academicservice.dto.DepartmentDTOGet;
import services.academicservice.entity.Department;

public class DepartmentConverter {

    public DepartmentDTOGet entityToDTO(Department department) {
        DepartmentDTOGet dto = new DepartmentDTOGet();
        dto.setDepartmentName(department.getDepartmentName());
        return dto;
    }

}
