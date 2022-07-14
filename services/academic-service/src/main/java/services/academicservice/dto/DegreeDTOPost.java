package services.academicservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class DegreeDTOPost {

	public final static String REGEX = "^[A-Za-záéíóúÁÉÍÓÚ]+( [A-Za-záéíóúÁÉÍÓÚ]+)*$";

	@Pattern(regexp=REGEX,message = "Invalid Input")
	@NotNull
	private String description;

	@NotNull
	private String type;

	private String alternativeDescription;

	@NotNull
	private boolean option;
	
}
