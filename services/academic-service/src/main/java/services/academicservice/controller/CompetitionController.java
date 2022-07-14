package services.academicservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.academicservice.dto.CompetitionDTOPost;
import services.academicservice.service.CompetitionService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/competitions")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @GetMapping
    public List<String> fetchCompetitions() {
        return competitionService.fetchAllCompetitions();
    }

    @PostMapping
    public ResponseEntity<String> createCareer(@Valid @RequestBody CompetitionDTOPost dto) {
        return competitionService.createCompetition(dto);
    }

}
