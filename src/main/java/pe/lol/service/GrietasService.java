package pe.lol.service;

import java.util.Collection;

import pe.lol.entity.Grietas;

public interface GrietasService {
	
	public abstract void insert(Grietas grietas);
	public abstract void update(Grietas grietas);
	public abstract void delete(Integer grietasId);
	public abstract Grietas findById(Integer grietasId);
	public abstract Collection<Grietas> findAll();

	public abstract boolean isEquipos (Integer grietasId);
}
