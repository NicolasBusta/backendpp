package services.academicservice.converter;

import services.academicservice.dto.CompetitionDTOPost;
import services.academicservice.entity.Competition;

public class CompetitionConverter {

    public Competition dtoToEntity(CompetitionDTOPost dto) {
        Competition competition = new Competition();
        competition.setCompetitionName(dto.getCompetitionName());
        competition.setCompetitionDescription(dto.getCompetitionDescription());

        return competition;
    }

}
