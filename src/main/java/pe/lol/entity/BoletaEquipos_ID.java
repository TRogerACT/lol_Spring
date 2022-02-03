package pe.lol.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class BoletaEquipos_ID implements Serializable
{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Boleta boleta;
	
	@ManyToOne
	private Equipos equipos;
	
	public BoletaEquipos_ID() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boleta == null) ? 0 : boleta.hashCode());
		result = prime * result + ((equipos == null) ? 0 : equipos.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoletaEquipos_ID other = (BoletaEquipos_ID) obj;
		if (boleta == null) {
			if (other.boleta != null)
				return false;
		} else if (!boleta.equals(other.boleta))
			return false;
		if (equipos == null) {
			if (other.equipos != null)
				return false;
		} else if (!equipos.equals(other.equipos))
			return false;
		return true;
	}



	public Boleta getBoleta() {
		return boleta;
	}


	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}


	public Equipos getEquipos() {
		return equipos;
	}


	public void setEquipos(Equipos equipos) {
		this.equipos = equipos;
	}
}
