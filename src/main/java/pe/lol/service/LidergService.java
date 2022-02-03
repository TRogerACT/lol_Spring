package pe.lol.service;

import java.util.Collection;

import pe.lol.entity.Liderg;

public interface LidergService 
{

	public abstract void insert(Liderg liderg);
	public abstract void update(Liderg liderg);
	public abstract void delete(Integer lidergId);
	public abstract Liderg findById(Integer lidergId);
	public abstract Collection<Liderg> findAll();
	
	public abstract boolean isEquipos (Integer lidergId);
}