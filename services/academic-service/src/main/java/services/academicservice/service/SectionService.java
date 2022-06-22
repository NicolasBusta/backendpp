package services.academicservice.service;

import org.springframework.http.ResponseEntity;
import services.academicservice.dto.SectionDtoGet;
import services.academicservice.dto.SectionDtoPost;

import java.util.List;

public interface SectionService {

    List<SectionDtoGet> fetchAllSections(Integer pageNo, Integer pageSize, String sortBy, String direction);

    SectionDtoGet fetchSectionById(Long id);

    ResponseEntity<String> createSection(SectionDtoPost dto);

    ResponseEntity<String> updateSection(Long id, SectionDtoPost dto);

    ResponseEntity<String> deleteSectionById(Long id);

}
