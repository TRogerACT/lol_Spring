package pe.lol.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.lol.entity.Roljg;
import pe.lol.repository.RoljgRepository;

@Service
public class RoljgServiceImpl implements RoljgService 
{
	@Autowired
	private RoljgRepository repository;
	
	@Override
	@Transactional
	public void insert(Roljg roljg) {
		repository.save(roljg);
		
	}

	@Override
	@Transactional
	public void update(Roljg roljg) {
		repository.save(roljg);
		
	}

	@Override
	@Transactional
	public void delete(Integer jgId) {
		repository.deleteById(jgId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Roljg findById(Integer jgId) {
		return repository.findById(jgId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Roljg> findAll() {
		return repository.findAll();
	}
}