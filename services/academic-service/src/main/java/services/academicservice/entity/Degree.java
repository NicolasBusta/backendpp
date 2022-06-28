package services.academicservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name ="ACADEMIC_DEGREES", schema = "academic")
public class Degree {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name ="ID")
	private Long id;
	
	@Column(name = "DEGREE_DESCRIPTION")
	private String description;
	
	@Column(name = "DEGREE_TYPE")
	private Short type;

	@Column(name = "DEGREE_ALTERNATIVE_NAME")
	private String alternativeName;

}
