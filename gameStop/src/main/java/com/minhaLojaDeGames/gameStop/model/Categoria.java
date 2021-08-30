package com.minhaLojaDeGames.gameStop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;

	@NotBlank
	@Size(min = 3, max = 150)
	private String tipo;

	@NotBlank
	@Size(min = 3, max = 200)
	private String descricao;

	@OneToMany(mappedBy = "codigoDaCategoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({ "codigoDaCategoria" })
	private List<Produto> categoriaGameStop = new ArrayList<>();

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getCategoriaGameStop() {
		return categoriaGameStop;
	}

	public void setCategoriaGameStop(List<Produto> categoriaGameStop) {
		this.categoriaGameStop = categoriaGameStop;
	}

}
