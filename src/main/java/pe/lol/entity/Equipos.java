package pe.lol.entity;

import java.io.Serializable;
import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="equiposs")
public class Equipos implements Serializable 
{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer equiposId;
	
	@Column(unique=true)
	private String nombres;
	
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate registro;
	
	@OneToOne
	@JoinColumn(name="imagen_id",nullable=false,unique=true,
			foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(imagen_id) references imagenes(imagen_id)"))
	private Imagen imagen;
	
	@OneToOne
	@JoinColumn(name="liderg_id",nullable=false,unique=true,
			foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(liderg_id) references lidergg(liderg_id)"))
	private Liderg liderg;
	
	@ManyToOne
	@JoinColumn(name="grietas_id",nullable=false,
		foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(grietas_id) references grietass(grietas_id)"))	
	private Grietas grietas;
	
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="equipos_campeones",
            joinColumns=@JoinColumn(name="equipos_id",
            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(equipos_id) references equiposs(equipos_id)")),
            inverseJoinColumns = @JoinColumn(name="mid_id",
            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(mid_id) references midd(mid_id)")))
    private Set<Rolmid> itemsMid=new HashSet<>();
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="equipos_campeones",
            joinColumns=@JoinColumn(name="equipos_id",
            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(equipos_id) references equiposs(equipos_id)")),
            inverseJoinColumns = @JoinColumn(name="adc_id",
            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(adc_id) references adcc(adc_id)"))) 
    private Set<Roladc> itemsAdc=new HashSet<>(); 
 
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="equipos_campeones",
            joinColumns=@JoinColumn(name="equipos_id",
            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(equipos_id) references equiposs(equipos_id)")),
            inverseJoinColumns = @JoinColumn(name="jg_id",
            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(jg_id) references jgg(jg_id)"))) 
    private Set<Roljg> itemsJg=new HashSet<>();    
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="equipos_campeones",
            joinColumns=@JoinColumn(name="equipos_id",
            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(equipos_id) references equiposs(equipos_id)")),
            inverseJoinColumns = @JoinColumn(name="sup_id",
            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(sup_id) references supp(sup_id)"))) 
    private Set<Rolsup> itemsSup=new HashSet<>();  
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="equipos_campeones",
            joinColumns=@JoinColumn(name="equipos_id",
            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(equipos_id) references equiposs(equipos_id)")),
            inverseJoinColumns = @JoinColumn(name="top_id",
            foreignKey=@ForeignKey(foreignKeyDefinition="foreign key(top_id) references topp(top_id)"))) 
    private Set<Roltop> itemsTop=new HashSet<>(); 
    
	@OneToMany(mappedBy="boletaEquiposId.equipos")
	private Set<BoletaEquipos> itemsBoletaEquipos=new HashSet<>();
    
	public Equipos() {
	
	}

	public Equipos(Integer equiposId, String nombres, LocalDate registro) {
		this.equiposId = equiposId;
		this.nombres = nombres;
		this.registro = registro;
	}
	
    public void addRoltop(Roltop roltop)
    {
    	itemsTop.add(roltop);
    	roltop.getItemsEquipos().add(this);
    }
    
    public void addRoljg(Roljg roljg)
    {
    	itemsJg.add(roljg);
    	roljg.getItemsEquipos().add(this);
    }
    
    public void addRolmid(Rolmid rolmid)
    {
    	itemsMid.add(rolmid);
    	rolmid.getItemsEquipos().add(this);
    }
    

    public void addRoladc(Roladc roladc)
    {
    	itemsAdc.add(roladc);
    	roladc.getItemsEquipos().add(this);
    }
    
    public void addRolsup(Rolsup rolsup)
    {
    	itemsSup.add(rolsup);
    	rolsup.getItemsEquipos().add(this);
    }



	public Integer getEquiposId() {
		return equiposId;
	}

	public void setEquiposId(Integer equiposId) {
		this.equiposId = equiposId;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public LocalDate getRegistro() {
		return registro;
	}

	public void setRegistro(LocalDate registro) {
		this.registro = registro;
	}

	public Imagen getImagen() {
		return imagen;
	}

	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}

	public Liderg getLiderg() {
		return liderg;
	}

	public void setLiderg(Liderg liderg) {
		this.liderg = liderg;
	}

	public Grietas getGrietas() {
		return grietas;
	}

	public void setGrietas(Grietas grietas) {
		this.grietas = grietas;
	}

	public Set<Rolmid> getItemsMid() {
		return itemsMid;
	}

	public Set<Roladc> getItemsAdc() {
		return itemsAdc;
	}

	public void setItemsAdc(Set<Roladc> itemsAdc) {
		this.itemsAdc = itemsAdc;
	}

	public Set<Roljg> getItemsJg() {
		return itemsJg;
	}

	public void setItemsJg(Set<Roljg> itemsJg) {
		this.itemsJg = itemsJg;
	}

	public Set<Rolsup> getItemsSup() {
		return itemsSup;
	}

	public void setItemsSup(Set<Rolsup> itemsSup) {
		this.itemsSup = itemsSup;
	}

	public Set<Roltop> getItemsTop() {
		return itemsTop;
	}

	public void setItemsTop(Set<Roltop> itemsTop) {
		this.itemsTop = itemsTop;
	}

	public void setItemsMid(Set<Rolmid> itemsMid) {
		this.itemsMid = itemsMid;
	}

	public Set<BoletaEquipos> getItemsBoletaEquipos() {
		return itemsBoletaEquipos;
	}

	public void setItemsBoletaEquipos(Set<BoletaEquipos> itemsBoletaEquipos) {
		this.itemsBoletaEquipos = itemsBoletaEquipos;
	}
	
	

}
