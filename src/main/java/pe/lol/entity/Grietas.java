package pe.lol.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.ArrayList;

@Entity
@Table(name="grietass")
public class Grietas implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer grietasId;
	
	@Column
	private String nombre;
	
	@OneToMany(mappedBy="grietas")
	private Collection<Equipos> itemsEquipos= new ArrayList<>();
	
	public Grietas() {
		
	}

	public Grietas(Integer grietasId, String nombre)
	{
		
		this.grietasId = grietasId;
		this.nombre = nombre;
	}


	public Integer getGrietasId() {
		return grietasId;
	}


	public void setGrietasId(Integer grietasId) {
		this.grietasId = grietasId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Equipos> getItemsEquipos() {
		return itemsEquipos;
	}

	public void setItemsEquipos(Collection<Equipos> itemsEquipos) {
		this.itemsEquipos = itemsEquipos;
	}
	
	

}

