package pe.lol.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.lol.entity.Imagen;
import pe.lol.repository.ImagenRepository;

@Service
public class ImagenServiceImpl implements ImagenService
{
	@Autowired
	private ImagenRepository repository;

	@Override
	@Transactional
	public void insert(Imagen imagen) {
		repository.save(imagen);
		
	}


	@Override
	@Transactional
	public void update(Imagen imagen) {
		repository.save(imagen);
		
	}

	@Override
	@Transactional
	public void delete(Integer imagenId) {
		repository.deleteById(imagenId);
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Imagen> findAll() {
		return repository.findAll();
	}


	@Override
	@Transactional(readOnly=true)
	public Imagen findById(Integer imagenId) {
		return repository.findById(imagenId).orElse(null);
	}

	
}
