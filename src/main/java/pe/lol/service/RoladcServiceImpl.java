package pe.lol.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.lol.entity.Roladc;
import pe.lol.repository.RoladcRepository;


@Service
public class RoladcServiceImpl implements RoladcService 
{
	@Autowired
	private RoladcRepository repository;
	
	@Override
	@Transactional
	public void insert(Roladc roladc) {
		repository.save(roladc);
		
	}

	@Override
	@Transactional
	public void update(Roladc roladc) {
		repository.save(roladc);
		
	}

	@Override
	@Transactional
	public void delete(Integer adcId) {
		repository.deleteById(adcId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Roladc findById(Integer adcId) {
		return repository.findById(adcId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Roladc> findAll() {
		return repository.findAll();
	}
}
