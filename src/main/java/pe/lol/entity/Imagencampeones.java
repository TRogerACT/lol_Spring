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
@Table(name="imagenes_campeones")
public class Imagencampeones implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer imagenId;
	
	@Column
	private String nombre;
	
	@Column(columnDefinition="longblob")
	private byte[] file;
	
	@OneToOne(mappedBy="imagencampeones") // fk a nivel de entidad
	private Rolmid rolmid;
	

	private Roladc roladc;
	
	private Rolsup rolsup;
	
	private Roltop roltop;
	
	private Roljg roljg;
	
	public Imagencampeones() {
		
	}

	public Imagencampeones(Integer imagenId, String nombre, byte[] file) {
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
	
	public Rolmid getRolmid() {
		return rolmid;
	}

	public void setRolmid(Rolmid rolmid) {
		this.rolmid = rolmid;
	}

	//convert byte[] to String
	public String getBase64Imagencampeones() 
	{
		String base64=Base64.getEncoder().encodeToString(this.file);
		return base64;
	}

	public Roladc getRoladc() {
		return roladc;
	}

	public void setRoladc(Roladc roladc) {
		this.roladc = roladc;
	}

	public Rolsup getRolsup() {
		return rolsup;
	}

	public void setRolsup(Rolsup rolsup) {
		this.rolsup = rolsup;
	}

	public Roltop getRoltop() {
		return roltop;
	}

	public void setRoltop(Roltop roltop) {
		this.roltop = roltop;
	}

	public Roljg getRoljg() {
		return roljg;
	}

	public void setRoljg(Roljg roljg) {
		this.roljg = roljg;
	}
	
	
	
}