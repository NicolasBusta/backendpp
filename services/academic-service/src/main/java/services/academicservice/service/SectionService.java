package services.academicservice.service;

import org.springframework.http.ResponseEntity;

import services.academicservice.dto.SectionDTOGet;
import services.academicservice.dto.SectionDTOPost;

import java.util.List;

public interface SectionService {

    List<SectionDTOGet> fetchAllSections(Integer pageNo, Integer pageSize, String sortBy, String direction);

    SectionDTOGet fetchSectionById(Long id);

    ResponseEntity<String> createSection(SectionDTOPost dto);

    ResponseEntity<String> updateSection(Long id, SectionDTOPost dto);

    ResponseEntity<String> deleteSectionById(Long id);

}
