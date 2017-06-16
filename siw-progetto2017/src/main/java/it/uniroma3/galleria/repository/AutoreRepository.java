package it.uniroma3.galleria.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.galleria.model.Autore;

public interface AutoreRepository extends CrudRepository<Autore, Long> {
	
	List<Autore> findByNome(String nome);
	
	List<Autore> findByCognome(String cognome);

}
