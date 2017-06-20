package it.uniroma3.galleria.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"nome","cognome"}))
public class Autore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=1)
	private String nome;
	
	@NotNull
	@Size(min=1)
	private String cognome;
	
	@NotNull
	@Size(min=1)
	private String nazione;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date dataNascita;
	
	@Temporal(TemporalType.DATE)
	private Date dataMorte;
	
	private String url;
	
	@OneToMany(mappedBy="autore", fetch=FetchType.LAZY, cascade={CascadeType.REMOVE})
	private List<Opera> opere;
	
	public Autore() {
		this.opere = new ArrayList<>();
	}
	
	public Autore(String nome, String cognome, String nazione, Date nascita) {
		this();
		this.nome = nome;
		this.cognome = cognome;
		this.nazione = nazione;
		this.dataNascita = nascita;
	}
	
	public Autore(String nome, String cognome, String nazione, Date nascita, Date morte) {
		this(nome, cognome, nazione, nascita);
		this.dataMorte = morte;
	}
	
	public Autore(String nome, String cognome, String nazione, Date nascita, String url) {
		this(nome, cognome, nazione, nascita);
		this.url = url;
	}
	
	public Autore(String nome, String cognome, String nazione, Date nascita, Date morte, String url) {
		this(nome, cognome, nazione, nascita);
		this.dataMorte = morte;
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Date getDataMorte() {
		return dataMorte;
	}

	public void setDataMorte(Date dataMorte) {
		this.dataMorte = dataMorte;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public List<Opera> getOpere() {
		return opere;
	}

	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Autore[id=%d, nome=%s, cognome=%s]",
				id, nome, cognome);
	}

}
