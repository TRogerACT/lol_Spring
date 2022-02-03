package pe.lol.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.lol.entity.Rolsup;
import pe.lol.repository.RolsupRepository;

@Service
public class RolsupServiceImpl implements RolsupService 
{
	@Autowired
	private RolsupRepository repository;
	
	@Override
	@Transactional
	public void insert(Rolsup rolsup) {
		repository.save(rolsup);
		
	}

	@Override
	@Transactional
	public void update(Rolsup rolsup) {
		repository.save(rolsup);
		
	}

	@Override
	@Transactional
	public void delete(Integer midId) {
		repository.deleteById(midId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Rolsup findById(Integer supId) {
		return repository.findById(supId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Rolsup> findAll() {
		return repository.findAll();
	}
}
