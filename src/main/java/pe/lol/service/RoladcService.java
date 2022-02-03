package pe.lol.service;

import java.util.Collection;

import pe.lol.entity.Roladc;


public interface RoladcService {
	public abstract void insert(Roladc roladc);
	public abstract void update(Roladc roladc);
	public abstract void delete(Integer adcId);
	public abstract Roladc findById(Integer adcId);
	public abstract Collection<Roladc> findAll();
	
}
