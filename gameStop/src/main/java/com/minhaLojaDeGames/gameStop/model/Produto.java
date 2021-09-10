package com.minhaLojaDeGames.gameStop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;

	@NotBlank
	private String nome;

	@NotBlank
	@Size(min = 3, max = 150)
	private String genero;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotBlank
	private String anoLancamento;

	@NotNull
	private float preco;

	@ManyToOne
	@JsonIgnoreProperties({ "categoriaGameStop" })
	@JoinColumn(name = "categoriaGamesStop")
	private Categoria codigoDaCategoria;
	
	@ManyToOne
	@JsonIgnoreProperties({"codigoComprador"})
	@JoinColumn(name = "codigoComprador")
	private Usuario codigoComprador;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String isAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Categoria getCodigoDaCategoria() {
		return codigoDaCategoria;
	}

	public void setCodigoDaCategoria(Categoria codigoDaCategoria) {
		this.codigoDaCategoria = codigoDaCategoria;
	}

}
