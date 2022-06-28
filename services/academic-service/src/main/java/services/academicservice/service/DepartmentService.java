package services.academicservice.service;

import services.academicservice.dto.DepartmentDTOGet;

import java.util.List;

public interface DepartmentService {

    public List<DepartmentDTOGet> fetchAllDepartments();

}
