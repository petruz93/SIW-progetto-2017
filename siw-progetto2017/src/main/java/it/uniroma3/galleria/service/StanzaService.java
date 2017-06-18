package it.uniroma3.galleria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.galleria.model.Stanza;
import it.uniroma3.galleria.repository.StanzaRepository;

@Service
public class StanzaService {
	
	@Autowired
	private StanzaRepository stanzaRepository;
	
	@Transactional
	public void add(final Stanza stanza) {
		this.stanzaRepository.save(stanza);
	}
	
	public Iterable<Stanza> findAll() {
		return this.stanzaRepository.findAll();
	}
	
	public Stanza findById(Long id) {
		return this.stanzaRepository.findOne(id);
	}
	
	@Transactional
	public void remove(Stanza stanza) {
		this.stanzaRepository.delete(stanza);
	}
	
	@Transactional
	public void removeById(Long id) {
		this.stanzaRepository.delete(id);
	}

}
