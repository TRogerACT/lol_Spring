package pe.lol.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.lol.dao.LidergDao;
import pe.lol.entity.Liderg;
import pe.lol.repository.LidergRepository;


@Service
public class LidergServiceImpl implements LidergService 
{
	@Autowired
	private LidergRepository repository;
	
	@Autowired
    private LidergDao dao;
	
	@Override
	@Transactional
	public void insert(Liderg liderg) {
		repository.save(liderg);
		
	}

	@Override
	@Transactional
	public void update(Liderg liderg) {
		repository.save(liderg);
		
	}

	@Override
	@Transactional
	public void delete(Integer lidergId) {
		repository.deleteById(lidergId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Liderg findById(Integer lidergId) {
		return repository.findById(lidergId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Liderg> findAll() {
		return repository.findAll();
	}
	
	@Override
    @Transactional(readOnly = true)
    public boolean isEquipos(Integer lidergId) {

        return dao.isEquipos(lidergId) ;
    }
}
