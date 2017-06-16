package it.uniroma3.galleria.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Stanza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=1)
	@Column(unique = true)
	private String nome;
	
	private String descrizione;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="stanza_id")
	private List<Opera> opere;
	
	public Stanza() {}
	
	public Stanza(String nome) {
		this.nome = nome;
	}
	
	public Stanza(String nome, String descrizione) {
		this.nome = nome;
		this.descrizione = descrizione;
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
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
				"Stanza[id=%d, nome=%s, descrizione=%s]",
				id, nome, descrizione);
	}

}
