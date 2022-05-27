package services.academicservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import services.academicservice.dto.SectionDtoGet;
import services.academicservice.service.SectionServiceImpl;
import services.academicservice.utils.ApiGet;

import java.util.List;

@RestController
@RequestMapping("/sections")
public class SectionController {

    private SectionServiceImpl sectionService;

    @Autowired
    public SectionController(SectionServiceImpl sectionService) {
        this.sectionService = sectionService;
    }

    @ApiGet
    public List<SectionDtoGet> fetchAllSections(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "ASC") String direction) {
        return sectionService.fetchAllSections(pageNo, pageSize, sortBy, direction);
    }

    @ApiGet("/{id}")
    public SectionDtoGet getSectionById(@PathVariable Long id) {
        return sectionService.fetchSectionById(id);
    }
}
