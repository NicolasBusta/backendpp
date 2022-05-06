package services.academicservice.dto;

import lombok.Getter;
import lombok.Setter;
import services.academicservice.entity.Degree;

@Getter
@Setter
public class DegreeDtoGet {

	private String descripcion;
	private Short tipo;
	
	public DegreeDtoGet(Degree degreeConst) {
		
		this.descripcion = degreeConst.getDescripcion();
		this.tipo = degreeConst.getTipo();
	}
	
}
