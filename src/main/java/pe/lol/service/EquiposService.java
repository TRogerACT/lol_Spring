package pe.lol.service;

import java.util.Collection;

import pe.lol.entity.Equipos;

public interface EquiposService {

	public abstract void insert(Equipos equipos);
	public abstract void update(Equipos equipos);
	public abstract void delete(Integer equiposId);
	public abstract Equipos findById(Integer equiposId);
	public abstract Collection<Equipos> findAll();
	
	public abstract Equipos findByNombres(String nombres);
	
	public abstract Collection<Object[]> find_AllEquiposCampeones();
}
