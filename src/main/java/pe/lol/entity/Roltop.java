package pe.lol.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="topp")
public class Roltop implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer topId;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;

	@OneToOne
	@JoinColumn(name="imagen_id",nullable=false,unique=true,
			foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(imagen_id) references imagenes_campeones(imagen_id)"))
	private Imagencampeones imagencampeones;
	
	@ManyToMany(mappedBy="itemsTop",fetch=FetchType.EAGER)
	private Set<Equipos> itemsEquipos=new HashSet<>();
	
	
	public Roltop() {
		// TODO Auto-generated constructor stub
	}


	public Roltop(Integer topId, String nombre, String descripcion) {
		this.topId = topId;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}


	public Integer getTopId() {
		return topId;
	}


	public void setTopId(Integer topId) {
		this.topId = topId;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Set<Equipos> getItemsEquipos() {
		return itemsEquipos;
	}


	public void setItemsEquipos(Set<Equipos> itemsEquipos) {
		this.itemsEquipos = itemsEquipos;
	}


	public Imagencampeones getImagencampeones() {
		return imagencampeones;
	}


	public void setImagencampeones(Imagencampeones imagencampeones) {
		this.imagencampeones = imagencampeones;
	}

	
	
}
