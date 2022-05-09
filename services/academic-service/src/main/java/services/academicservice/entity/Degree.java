package services.academicservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import services.academicservice.dto.DegreeDtoPost;



@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="ACADEMIC_DEGREES",schema = "academic")
public class Degree {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)/* generador incremental de registros*/
	@Column (name ="ID")
	private Long id;
	
	@Column(name = "DEGREE_DESCRIPTION")/* generador Getters*/
	private String descripcion; /* propiedades*/
	
	@Column(name = "DEGREE_TYPE")
	private Short tipo;

	@Column(name = "DEGREE_ALTERNATIVE_NAME")
	private String nombreAlternativo;
	
	public Degree(DegreeDtoPost degreeDtoPost) {
		descripcion = degreeDtoPost.getDescripcion();
		tipo = degreeDtoPost.getTipo();
	}
}
