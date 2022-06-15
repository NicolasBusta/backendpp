package services.academicservice.converter;

import services.academicservice.dto.DepartmentDtoGet;
import services.academicservice.entity.Department;

public class DepartmentConverter {

    public DepartmentDtoGet entityToDTO(Department department) {
        DepartmentDtoGet dto = new DepartmentDtoGet();
        dto.setDepartmentName(department.getDepartmentName());
        return dto;
    }

}
