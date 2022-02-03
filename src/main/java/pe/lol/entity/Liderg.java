package pe.lol.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="lidergg")
public class Liderg implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer lidergId;
	
	@Column
	private String nombre;
	
	@OneToOne(mappedBy="liderg") // fk a nivel de entidad
	private Equipos equipos;
	
	public Liderg() {
		// TODO Auto-generated constructor stub
	}

	public Liderg(Integer lidergId, String nombre) {
		this.lidergId = lidergId;
		this.nombre = nombre;
	}

	public Integer getLidergId() {
		return lidergId;
	}

	public void setLidergId(Integer lidergId) {
		this.lidergId = lidergId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Equipos getEquipos() {
		return equipos;
	}

	public void setEquipos(Equipos equipos) {
		this.equipos = equipos;
	}
	
}
