package com.farmacia.doTrabalhadorBrasileiro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;

	@NotBlank
	@Size(min = 2, max = 100)
	private String nomeRemedio;

	@NotNull
	private float precoRemedio;

	private boolean laboratorio;

	private boolean tarjaPreta;

	@ManyToOne
	@JsonIgnoreProperties({ "codigoRemedios" })
	@JoinColumn(name = "codigoRemedios")
	private Categoria idRemedios;

	@ManyToOne
	@JsonIgnoreProperties({ "codigoUsuario" })
	@JoinColumn(name = "codigoUsuario")
	private Usuario comprador;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeRemedio() {
		return nomeRemedio;
	}

	public void setNomeRemedio(String nomeRemedio) {
		this.nomeRemedio = nomeRemedio;
	}

	public float getPrecoRemedio() {
		return precoRemedio;
	}

	public void setPrecoRemedio(float precoRemedio) {
		this.precoRemedio = precoRemedio;
	}

	public boolean isLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(boolean laboratorio) {
		this.laboratorio = laboratorio;
	}

	public boolean isTarjaPreta() {
		return tarjaPreta;
	}

	public void setTarjaPreta(boolean tarjaPreta) {
		this.tarjaPreta = tarjaPreta;
	}

	public Categoria getIdRemedios() {
		return idRemedios;
	}

	public void setIdRemedios(Categoria idRemedios) {
		this.idRemedios = idRemedios;

	}

	public Usuario getComprador() {
		return comprador;
	}

	public void setComprador(Usuario comprador) {
		this.comprador = comprador;
	}

}
