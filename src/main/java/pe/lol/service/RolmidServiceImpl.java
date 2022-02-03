package pe.lol.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.lol.entity.Rolmid;
import pe.lol.repository.RolmidRepository;

@Service
public class RolmidServiceImpl implements RolmidService 
{
	@Autowired
	private RolmidRepository repository;
	
	@Override
	@Transactional
	public void insert(Rolmid rolmid) {
		repository.save(rolmid);
		
	}

	@Override
	@Transactional
	public void update(Rolmid rolmid) {
		repository.save(rolmid);
		
	}

	@Override
	@Transactional
	public void delete(Integer midId) {
		repository.deleteById(midId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Rolmid findById(Integer midId) {
		return repository.findById(midId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Rolmid> findAll() {
		return repository.findAll();
	}
}