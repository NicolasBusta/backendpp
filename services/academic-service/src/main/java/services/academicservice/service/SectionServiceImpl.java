package services.academicservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import services.academicservice.converter.SectionConverter;
import services.academicservice.dto.SectionDtoGet;
import services.academicservice.dto.SectionDtoPost;
import services.academicservice.entity.Section;
import services.academicservice.exception.SectionNotFoundException;
import services.academicservice.repository.SectionRepository;
import services.academicservice.repository.SubjectRepository;
import services.academicservice.repository.TermRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionServiceImpl {

    private SectionRepository sectionRepository;
    private TermRepository termRepository;
    private SubjectRepository subjectRepository;
    private SectionConverter sectionConverter;

    public SectionServiceImpl(SectionRepository sectionRepository, TermRepository termRepository, SubjectRepository subjectRepository) {
        this.sectionRepository = sectionRepository;
        this.sectionConverter = new SectionConverter(termRepository, subjectRepository);
    }

    /**
     *
     * @param pageNo page number to display
     * @param pageSize number of objects shown per page
     * @param direction ascendant or descendant
     * @param sortBy field to be ordered by
     * @return list of section DTO objects
     */
    public List<SectionDtoGet> fetchAllSections(Integer pageNo, Integer pageSize, String sortBy, String direction) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.Direction.fromString(direction), sortBy);
        Page<Section> sections = sectionRepository.findAll(paging);
        List<SectionDtoGet> sectionDtoGetList = new ArrayList<>();
        for (Section section: sections) {
            sectionDtoGetList.add(sectionConverter.entityToDTO(section));
        }
        return sectionDtoGetList;
    }

    /**
     *
     * @param id id of section to be searched
     * @return section object which id correlate with the request
     */
    public SectionDtoGet fetchSectionById(Long id) {
        Section section = sectionRepository.findById(id)
                .orElseThrow(() -> new SectionNotFoundException("Section id not found - " + id));
        SectionDtoGet sectionDtoGet = sectionConverter.entityToDTO(section);
        return sectionDtoGet;
    }

    /**
     *
     * @param dto DTO which contains specified fields for different tables
     * @return responseEntity object which contains a message and a HTTP status
     */
    public ResponseEntity<String> createSection(SectionDtoPost dto) {
        String newName = dto.getSectionName();
        if (sectionRepository.findAllSectionsBy(newName).isEmpty()) {
            Section section = sectionConverter.dtoToEntity(dto);
            sectionRepository.save(section);
            return new ResponseEntity<String>("Section created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Section already exists", HttpStatus.CONFLICT);
        }
    }

}
