package pe.lol.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.lol.dao.GrietasDao;
import pe.lol.entity.Grietas;
import pe.lol.repository.GrietasRepository;

@Service
public class GrietasServiceImpl implements GrietasService
{
	
	@Autowired
	private GrietasRepository repository;
	
	@Autowired
    private GrietasDao dao;
	
	
	@Override
	@Transactional
	public void insert(Grietas grietas) {
		repository.save(grietas);
		
	}

	@Override
	@Transactional
	public void update(Grietas grietas) {
		repository.save(grietas);
		
	}

	@Override
	@Transactional
	public void delete(Integer grietasId) {
		repository.deleteById(grietasId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Grietas findById(Integer grietasId) {
		return repository.findById(grietasId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Grietas> findAll() {
		return repository.findAll();
	}

	@Override
    @Transactional(readOnly = true)
    public boolean isEquipos(Integer grietasId) {

        return dao.isEquipos(grietasId) ;
    }
}
