package pe.lol.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
@Table(name="boletas")
public class Boleta implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator="BoletaGenerator")
	@TableGenerator(name="BoletaGenerator",initialValue=1020,allocationSize=1)
	private Integer boletaId;
	
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fecha;
	
	@Column
	private Double subtotal;
	
	@Column
	private Double igv;
	
	@Column
	private Double total;
	
	@OneToMany(mappedBy="boletaEquiposId.boleta")
	private Set<BoletaEquipos> itemsBoletaEquipos=new HashSet<>();
	
	public Boleta() {
	
	}

	public Boleta(Integer boletaId, LocalDate fecha, Double subtotal, Double igv, Double total) {
		this.boletaId = boletaId;
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.igv = igv;
		this.total = total;
	}

	public Integer getBoletaId() {
		return boletaId;
	}

	public void setBoletaId(Integer boletaId) {
		this.boletaId = boletaId;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getIgv() {
		return igv;
	}

	public void setIgv(Double igv) {
		this.igv = igv;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	
}