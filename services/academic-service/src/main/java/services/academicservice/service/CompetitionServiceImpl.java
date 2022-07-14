package services.academicservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import services.academicservice.converter.CompetitionConverter;
import services.academicservice.dto.CompetitionDTOPost;
import services.academicservice.entity.Competition;
import services.academicservice.repository.CompetitionRepository;

import java.util.List;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    private CompetitionConverter competitionConverter;

    public CompetitionServiceImpl() {
        this.competitionConverter = new CompetitionConverter();
    }

    public List<String> fetchAllCompetitions() {
        return competitionRepository.getAllCompetitionsByName();
    }

    public ResponseEntity<String> createCompetition(CompetitionDTOPost dto) {
        String newName = dto.getCompetitionName();
        if (competitionRepository.findAllCompetitionsBy(newName).isEmpty()) {
            Competition competition = competitionConverter.dtoToEntity(dto);
            competitionRepository.save(competition);
            return new ResponseEntity<>("Competition created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Competition already exists", HttpStatus.CONFLICT);
        }
    }

}
