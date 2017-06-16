package it.uniroma3.galleria.model;

import java.awt.Dimension;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Opera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=1)
	@Column(unique = true)
	private String titolo;
	
	@NotNull
	private Integer anno;
	
	@NotNull
	@Size(min=1)
	private String tecnica;
	
	@NotNull
	private Dimension dimensioni;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@NotNull
	private Autore autore;
	
	public Opera() {}
	
	public Opera(String titolo, Integer anno, String tecnica, int larghezza, int altezza, Autore autore) {
		this.titolo = titolo;
		this.anno = anno;
		this.tecnica = tecnica;
		this.dimensioni = new Dimension(larghezza, altezza);
		this.autore = autore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public Dimension getDimensioni() {
		return dimensioni;
	}

	public void setDimensioni(Dimension dimensioni) {
		this.dimensioni = dimensioni;
	}
	
	public void setDimensioni(int larghezza, int altezza) {
		this.dimensioni = new Dimension(larghezza, altezza);
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Opera[id=%d, titolo=%s]",
				id, titolo);
	}

}
