package pe.lol.service;

import java.util.Collection;

import pe.lol.entity.Roljg;

public interface RoljgService {
	public abstract void insert(Roljg roljg);
	public abstract void update(Roljg roladc);
	public abstract void delete(Integer jgId);
	public abstract Roljg findById(Integer jgId);
	public abstract Collection<Roljg> findAll();
	
}
