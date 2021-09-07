package com.farmacia.doTrabalhadorBrasileiro.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.farmacia.doTrabalhadorBrasileiro.model.Usuario;

public class UsuarioDetalhes implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nomeUsuario;
	private String senha;
	private List<GrantedAuthority> acesso;

	public UsuarioDetalhes(Usuario login) {
		this.nomeUsuario = login.getEmail();
		this.senha = login.getSenha();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return acesso;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nomeUsuario;
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
