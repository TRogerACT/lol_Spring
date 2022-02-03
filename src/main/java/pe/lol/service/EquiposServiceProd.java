package pe.lol.service;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.lol.dao.EquiposDao;
import pe.lol.entity.Equipos;
import pe.lol.repository.EquiposRepository;

@Service
@Profile("production")
public class EquiposServiceProd implements EquiposService 
{
	@Autowired
	private EquiposRepository repositoryProd;
	
	@Autowired
	private EquiposDao dao;	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void insert(Equipos equipos) {
		repositoryProd.save(equipos);
		
	}

	@Override
	@Transactional
	public void update(Equipos equipos) {
		repositoryProd.save(equipos);
		
	}

	@Override
	@Transactional
	public void delete(Integer equiposId) {
		repositoryProd.deleteById(equiposId);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Equipos findById(Integer equiposId) {
		return repositoryProd.findById(equiposId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Equipos> findAll() {
		return repositoryProd.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Equipos findByNombres(String nombres) 
	{
		Query query=entityManager.createNativeQuery("select * from equiposs where nombres=?1",Equipos.class);
		query.setParameter(1, nombres);
		return (Equipos)query.getSingleResult();
	}
    @Override
    @Transactional(readOnly=true)
    public Collection<Object[]> find_AllEquiposCampeones() {
    	return dao.find_AllEquiposCampeones();
    }

}