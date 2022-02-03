package pe.lol.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.lol.entity.Roltop;
import pe.lol.repository.RoltopRepository;

@Service
public class RoltopServiceImpl implements RoltopService 
{
	@Autowired
	private RoltopRepository repository;
	
	@Override
	@Transactional
	public void insert(Roltop roltop) {
		repository.save(roltop);
		
	}

	@Override
	@Transactional
	public void update(Roltop roltop) {
		repository.save(roltop);
		
	}

	@Override
	@Transactional
	public void delete(Integer topId) {
		repository.deleteById(topId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Roltop findById(Integer topId) {
		return repository.findById(topId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Roltop> findAll() {
		return repository.findAll();
	}
}