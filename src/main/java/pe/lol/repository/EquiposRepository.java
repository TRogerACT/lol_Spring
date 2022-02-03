package pe.lol.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import pe.lol.entity.Equipos;

//uso de spring data
public interface EquiposRepository extends JpaRepository<Equipos, Integer>
{
	// forma#2 (5QL, en base a tablas)
	/*
	@Query(value="select * from equiposs where nombres=?1",nativeQuery=true)
	public abstract Equipos findByNombres(String nombres);
	*/
	
	// Forma#3 (SOL, en base a tablas)
	/*
	@Query(value="select * from equiposs where nombres:name",nativeQuery=true)
	public abstract Producto findByNombres(Param{"name") String nombres);
	*/
	
	//forma#4 (JPOL, en base a entidades)
	/*
	@Query(value="select e from Equipos p where e.nombres=?1")
	public abstract Equipos findByNombres(String nombres);
	*/
	
	//forma#5 (en automático Spring Data te lo resuelve por las palabras mágicas find By propiedad)
	public abstract Equipos findByNombres(String nombres);	
	
}
