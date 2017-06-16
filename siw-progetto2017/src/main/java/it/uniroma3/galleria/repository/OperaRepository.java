package it.uniroma3.galleria.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.galleria.model.Opera;

public interface OperaRepository extends CrudRepository<Opera, Long> {
	
	List<Opera> findByTitolo(String titolo);

}
