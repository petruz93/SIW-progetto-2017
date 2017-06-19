package it.uniroma3.galleria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Authorities {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@OneToOne
	private Users username;
	
	@NotNull
	private String authoriry;
	
	public Authorities() {}
	
	public Authorities(Users user, String authority) {
		this.username = user;
		this.authoriry = authority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getUsername() {
		return username;
	}

	public void setUsername(Users username) {
		this.username = username;
	}

	public String getAuthoriry() {
		return authoriry;
	}

	public void setAuthoriry(String authoriry) {
		this.authoriry = authoriry;
	}

}
