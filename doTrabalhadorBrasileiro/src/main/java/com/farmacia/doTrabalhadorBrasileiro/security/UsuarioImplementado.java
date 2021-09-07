package com.farmacia.doTrabalhadorBrasileiro.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.farmacia.doTrabalhadorBrasileiro.model.Usuario;
import com.farmacia.doTrabalhadorBrasileiro.repository.UsuarioRepository;

@Service
public class UsuarioImplementado implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository5;

	@Override
	public UserDetails loadUserByUsername(String emailLogin) throws UsernameNotFoundException {
		Optional<Usuario> objectOptional = repository5.findByEmail(emailLogin);

		if (objectOptional.isPresent()) {
			return new UsuarioDetalhes(objectOptional.get());

		} else {

			throw new UsernameNotFoundException(emailLogin + "inexistente...");

		}

	}

}
