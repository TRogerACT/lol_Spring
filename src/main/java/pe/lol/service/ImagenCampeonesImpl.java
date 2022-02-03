package pe.lol.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.lol.entity.Imagencampeones;
import pe.lol.repository.ImagenCampeonesRepository;


@Service
public class ImagenCampeonesImpl implements ImagenCampeonesService
{
	@Autowired
	private ImagenCampeonesRepository repository;

	@Override
	@Transactional
	public void insert(Imagencampeones imagencampeones) {
		repository.save(imagencampeones);
		
	}


	@Override
	@Transactional
	public void update(Imagencampeones imagencampeones){
		repository.save(imagencampeones);
		
	}

	@Override
	@Transactional
	public void delete(Integer imagenId) {
		repository.deleteById(imagenId);
		
	}
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Imagencampeones> findAll() {
		return repository.findAll();
	}


	@Override
	@Transactional(readOnly=true)
	public Imagencampeones findById(Integer imagenId) {
		return repository.findById(imagenId).orElse(null);
	}
}



