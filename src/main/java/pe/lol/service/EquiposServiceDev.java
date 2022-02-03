package pe.lol.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import pe.lol.entity.Equipos;

@Component
@Profile ("developing")
public class EquiposServiceDev implements EquiposService
{
	
	private static Map<Integer,Equipos> repositoryDev=new HashMap<>();
	static
	{
		Equipos equipos1=new Equipos(1,"T1",LocalDate.of(2021,10,13));
		Equipos equipos2=new Equipos(2,"G2 Esports",LocalDate.of(2021,10,15));
		
		repositoryDev.put(equipos1.getEquiposId(), equipos1);
		repositoryDev.put(equipos2.getEquiposId(), equipos2);
	}

	@Override
	public void insert(Equipos equipos) {
		equipos.setEquiposId(repositoryDev.size()+1);
		repositoryDev.put(equipos.getEquiposId(),equipos);
		
	}

	@Override
	public void update(Equipos equipos) {
		repositoryDev.put(equipos.getEquiposId(),equipos);
		
	}

	@Override
	public void delete(Integer equiposId) {
		repositoryDev.remove(equiposId);
		
	}

	@Override
	public Equipos findById(Integer equiposId) {
		return repositoryDev.get(equiposId);
	}

	@Override
	public Collection<Equipos> findAll() {
		return repositoryDev.values();
	}
	@Override
	public Equipos findByNombres(String nombres) {
		Collection<Equipos> baraja=repositoryDev.values();
		
		for(Equipos equipos:baraja)
		{
			if(equipos.getNombres().equals(nombres)) 
			{
				return equipos;
			}
		}
		return null;
		
	}

	@Override
	public Collection<Object[]> find_AllEquiposCampeones() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
