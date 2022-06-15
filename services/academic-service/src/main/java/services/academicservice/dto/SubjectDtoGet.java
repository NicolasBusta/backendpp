package services.academicservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SubjectDtoGet {

    private String subjectCode;
	private String subjectDescription;
	private Boolean subjectStatus;
	private Short subjectDuration;
	private Short subjectType;
	private Long subjectHours;
	private Long subjectCredits;
