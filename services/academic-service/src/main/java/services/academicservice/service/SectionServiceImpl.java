package services.academicservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import services.academicservice.dto.SectionDtoGet;
import services.academicservice.entity.Section;
import services.academicservice.exception.SectionNotFoundException;
import services.academicservice.repository.SectionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionServiceImpl {

    private SectionRepository sectionRepository;

    public SectionServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
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
            sectionDtoGetList.add(new SectionDtoGet(section, section.getSubject(), section.getTerm()));
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
        SectionDtoGet sectionDtoGet = new SectionDtoGet(section, section.getSubject(), section.getTerm());
        return sectionDtoGet;
    }
}
