package services.academicservice.service;

import org.springframework.stereotype.Service;

import services.academicservice.converter.DepartmentConverter;
import services.academicservice.dto.DepartmentDTOGet;
import services.academicservice.entity.Department;
import services.academicservice.repository.DepartmentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl {

    private DepartmentRepository departmentRepository;
    private DepartmentConverter departmentConverter;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
        this.departmentConverter = new DepartmentConverter();
    }

    public List<DepartmentDTOGet> fetchAllDepartments() {
        List<Department> departmentList = departmentRepository.findAll();
        List<DepartmentDTOGet> dtoList = new ArrayList<>();
        for (Department department : departmentList) {
            dtoList.add(departmentConverter.entityToDTO(department));
        }
        return dtoList;
    }

}
