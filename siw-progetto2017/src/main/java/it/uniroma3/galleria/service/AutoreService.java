package it.uniroma3.galleria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.galleria.model.Autore;
import it.uniroma3.galleria.repository.AutoreRepository;

@Service
public class AutoreService {
	
	@Autowired
	private AutoreRepository autoreRepository;
	
	@Transactional
	public void add(final Autore autore) {
		this.autoreRepository.save(autore);
	}
	
	public Iterable<Autore> findAll() {
		return this.autoreRepository.findAll();
	}
	
	public Autore findById(Long id) {
		return this.autoreRepository.findOne(id);
	}
	
	@Transactional
	public void remove(Autore autore) {
		this.autoreRepository.delete(autore);
	}
	
	@Transactional
	public void removeById(Long id) {
		this.autoreRepository.delete(id);
	}

}
