package pe.lol.entity;

import java.io.Serializable;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="imagenes")
public class Imagen implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer imagenId;
	
	@Column
	private String nombre;
	
	@Column(columnDefinition="longblob")
	private byte[] file;
	
	@OneToOne(mappedBy="imagen") // fk a nivel de entidad
	private Equipos equipos;
	
	public Imagen() {
		
	}

	public Imagen(Integer imagenId, String nombre, byte[] file) {
		this.imagenId = imagenId;
		this.nombre = nombre;
		this.file = file;
	}

	public Integer getImagenId() {
		return imagenId;
	}

	public void setImagenId(Integer imagenId) {
		this.imagenId = imagenId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public Equipos getEquipos() {
		return equipos;
	}

	public void setEquipos(Equipos equipos) {
		this.equipos = equipos;
	}
	
	//convert byte[] to String
	public String getBase64Imagen() 
	{
		String base64=Base64.getEncoder().encodeToString(this.file);
		return base64;
	}
	
}
