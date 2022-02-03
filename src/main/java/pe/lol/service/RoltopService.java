package pe.lol.service;

import java.util.Collection;

import pe.lol.entity.Roltop;


public interface RoltopService {
	public abstract void insert(Roltop roltop);
	public abstract void update(Roltop roltop);
	public abstract void delete(Integer topId);
	public abstract Roltop findById(Integer topId);
	public abstract Collection<Roltop> findAll();
}

