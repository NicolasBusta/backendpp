package services.academicservice.service;

import org.springframework.http.ResponseEntity;
import services.academicservice.dto.CompetitionDTOPost;

import java.util.List;

public interface CompetitionService {

    List<String> fetchAllCompetitions();

    ResponseEntity<String> createCompetition(CompetitionDTOPost dto);

}
