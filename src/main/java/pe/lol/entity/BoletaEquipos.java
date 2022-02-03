package pe.lol.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="boletas_equipos")
@AssociationOverrides({
	@AssociationOverride(name="boletaEquiposId.boleta",
		joinColumns=@JoinColumn(name="bodega_id",nullable=false,
		foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(bodega_id) references boletas(bodega_id)"))),
	@AssociationOverride(name="boletaEquiposId.equipos",
		joinColumns=@JoinColumn(name="equipos_id",nullable=false,
		foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(equipos_id) references equiposs(equipos_id)")))	
})
public class BoletaEquipos implements Serializable
{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BoletaEquipos_ID boletaEquiposId=new BoletaEquipos_ID();
	
	@Column
	private Integer cantidad;
	
	@Column
	private Double precio_unitario;
	
	@Column
	private Double importe;
	
	public BoletaEquipos() {
		
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boletaEquiposId == null) ? 0 : boletaEquiposId.hashCode());
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
		BoletaEquipos other = (BoletaEquipos) obj;
		if (boletaEquiposId == null) {
			if (other.boletaEquiposId != null)
				return false;
		} else if (!boletaEquiposId.equals(other.boletaEquiposId))
			return false;
		return true;
	}


	//normal
	
	public BoletaEquipos_ID getBoletaEquiposId() {
		return boletaEquiposId;
	}

	public void setBoletaEquiposId(BoletaEquipos_ID boletaEquiposId) {
		this.boletaEquiposId = boletaEquiposId;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(Double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}
	
	
	//extra
	
	public Boleta getBoleta() {
		return boletaEquiposId.getBoleta();
	}


	public void setBoleta(Boleta boleta) {
		this.boletaEquiposId.setBoleta(boleta);
	}


	public Equipos getEquipos() {
		return boletaEquiposId.getEquipos();
	}


	public void setEquipos(Equipos equipos) {
		this.boletaEquiposId.setEquipos(equipos);
	}	
	
}
