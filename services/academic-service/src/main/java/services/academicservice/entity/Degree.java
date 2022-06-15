package services.academicservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import services.academicservice.dto.DegreeDtoPost;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="ACADEMIC_DEGREES", schema = "academic")
public class Degree {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name ="ID")
	private Long id;
	
	@Column(name = "DEGREE_DESCRIPTION")
	private String descripcion;
	
	@Column(name = "DEGREE_TYPE")
	private Short tipo;

	@Column(name = "DEGREE_ALTERNATIVE_NAME")
	private String nombreAlternativo;
	
	public Degree(DegreeDtoPost degreeDtoPost) {
		descripcion = degreeDtoPost.getDescripcion();
		tipo = degreeDtoPost.getTipo();
	}

}
