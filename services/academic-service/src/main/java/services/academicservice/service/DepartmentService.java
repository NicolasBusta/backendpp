package services.academicservice.service;

import services.academicservice.dto.DepartmentDtoGet;

import java.util.List;

public interface DepartmentService {

    public List<DepartmentDtoGet> fetchAllDepartments();

}
