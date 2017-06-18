package it.uniroma3.galleria.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"titolo","autore"}))
public class Opera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=1)
	private String titolo;
	
	@NotNull
	private Integer anno;
	
	@NotNull
	@Size(min=1)
	private String tecnica;
	
	@NotNull
	@Min(0)
	private Integer altezza;
	
	@NotNull
	@Min(0)
	private Integer larghezza;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@NotNull
	private Autore autore;
	
	public Opera() {}
	
	public Opera(String titolo, Integer anno, String tecnica, Integer larghezza, Integer altezza, Autore autore) {
		this.titolo = titolo;
		this.anno = anno;
		this.tecnica = tecnica;
		this.altezza = altezza;
		this.larghezza = larghezza;
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
	
	public Integer getAltezza() {
		return altezza;
	}
	
	public void setAltezza(Integer altezza) {
		this.altezza = altezza;
	}
	
	public Integer getLarghezza() {
		return larghezza;
	}
	
	public void setLarghezza(Integer larghezza) {
		this.larghezza = larghezza;
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
