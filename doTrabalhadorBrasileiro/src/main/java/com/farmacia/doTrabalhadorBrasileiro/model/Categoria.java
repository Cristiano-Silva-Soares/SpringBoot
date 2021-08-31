package com.farmacia.doTrabalhadorBrasileiro.model;

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
	@Size(min = 3, max = 30)
	private String categoriaRemedio;

	@NotBlank
	@Size(min = 3, max = 30)
	private String formaRemedio;
	
	@OneToMany(mappedBy = "idRemedios", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"idRemedios"})
	private List<Produto> codigoRemedios = new ArrayList<>();
	

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCategoriaRemedio() {
		return categoriaRemedio;
	}

	public void setCategoriaRemedio(String categoriaRemedio) {
		this.categoriaRemedio = categoriaRemedio;
	}

	public String getFormaRemedio() {
		return formaRemedio;
	}

	public void setFormaRemedio(String formaRemedio) {
		this.formaRemedio = formaRemedio;
	}

	public List<Produto> getCodigoRemedios() {
		return codigoRemedios;
	}

	public void setCodigoRemedios(List<Produto> codigoRemedios) {
		this.codigoRemedios = codigoRemedios;
	}
	
}
