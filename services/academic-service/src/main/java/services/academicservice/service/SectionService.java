package services.academicservice.service;

import services.academicservice.dto.SectionDtoGet;

import java.util.List;

public interface SectionService {

    List<SectionDtoGet> fetchAllSections(Integer pageNo, Integer pageSize, String sortBy, String direction);

    SectionDtoGet fetchSectionById(Long id);
}
