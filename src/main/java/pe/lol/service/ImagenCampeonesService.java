package pe.lol.service;

import java.util.Collection;

import pe.lol.entity.Imagencampeones;



public interface ImagenCampeonesService {
	public abstract void insert(Imagencampeones imagencampeones);
	public abstract void update(Imagencampeones imagencampeones);
	public abstract void delete(Integer imagenId);
	public abstract Imagencampeones findById(Integer imagenId);
	public abstract Collection<Imagencampeones> findAll();


}