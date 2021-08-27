package org.generation.blogPessoal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
public class Usuario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	
	@NotBlank
	private String nomeUsuario;
	
	@NotBlank
	@Email
	private String  email;
	
	@NotBlank
	@Size(min = 6)
	private int senha;
	
	@OneToMany(mappedBy = "criador", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"criador"})
	private List<Postagem> minhasPostagens = new ArrayList<>();
	
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	
}
