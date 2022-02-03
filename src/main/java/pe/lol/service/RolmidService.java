package pe.lol.service;

import java.util.Collection;

import pe.lol.entity.Rolmid;


public interface RolmidService {
	public abstract void insert(Rolmid rolmid);
	public abstract void update(Rolmid rolmid);
	public abstract void delete(Integer midId);
	public abstract Rolmid findById(Integer midId);
	public abstract Collection<Rolmid> findAll();
}