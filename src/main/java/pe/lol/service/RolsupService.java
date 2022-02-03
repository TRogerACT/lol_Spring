package pe.lol.service;

import java.util.Collection;

import pe.lol.entity.Rolsup;



public interface RolsupService {
	public abstract void insert(Rolsup rolsup);
	public abstract void update(Rolsup rolsup);
	public abstract void delete(Integer supId);
	public abstract Rolsup findById(Integer supId);
	public abstract Collection<Rolsup> findAll();
}
