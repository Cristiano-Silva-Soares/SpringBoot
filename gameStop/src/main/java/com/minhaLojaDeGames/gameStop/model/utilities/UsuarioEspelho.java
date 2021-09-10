package com.minhaLojaDeGames.gameStop.model.utilities;

/**
 * Classe Responsável pela segurança de informações referente ao usuário(seria a
 * primeira camada de proteção).
 * 
 * @author Cristiano
 * @Since 1.0
 *
 */

public class UsuarioEspelho {

	private String email;
	private String senha;

	private Long idUsuario;
	private String nomeUsuario;
	private String token;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
