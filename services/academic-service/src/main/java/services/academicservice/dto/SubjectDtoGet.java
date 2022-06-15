package services.academicservice.dto;

import lombok.Getter;
import lombok.Setter;
import services.academicservice.entity.Subject;

@Getter
@Setter
public class SubjectDtoGet {

	private String subjectCode;
	private String subjectDescription;
	private Boolean subjectStatus;
	private Short subjectDuration;
	private Short subjectType;
	private Long subjectHours;
	private Long subjectCredits;
	
	public SubjectDtoGet(Subject SubjectConst) {
		this.subjectCode = SubjectConst.getSubjectCode();
		this.subjectDescription = SubjectConst.getSubjectDescription();
		this.subjectStatus = SubjectConst.getSubjectStatus();
		this.subjectDuration = SubjectConst.getSubjectDuration();
		this.subjectType = SubjectConst.getSubjectType();
		this.subjectHours = SubjectConst.getSubjectHours();
		this.subjectCredits = SubjectConst.getSubjectCredits();
	}
}
