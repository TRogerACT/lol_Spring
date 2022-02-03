package pe.lol.service;

import java.util.Collection;

import pe.lol.entity.Imagen;

public interface ImagenService 
{
	public abstract void insert(Imagen imagen);
	public abstract void update(Imagen imagen);
	public abstract void delete(Integer imagenId);
	public abstract Imagen findById(Integer imagenId);
	public abstract Collection<Imagen> findAll();


}
