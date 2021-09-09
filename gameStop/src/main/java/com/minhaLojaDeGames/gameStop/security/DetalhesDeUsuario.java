package com.minhaLojaDeGames.gameStop.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.minhaLojaDeGames.gameStop.model.Usuario;

public class DetalhesDeUsuario implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String identidadeUsuario;
	private String senhaUsuario;
	private List<GrantedAuthority> acesso;

	public DetalhesDeUsuario(Usuario credenciado) {
		this.identidadeUsuario = credenciado.getEmail();
		this.senhaUsuario = credenciado.getSenha();

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return acesso;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senhaUsuario;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return identidadeUsuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
