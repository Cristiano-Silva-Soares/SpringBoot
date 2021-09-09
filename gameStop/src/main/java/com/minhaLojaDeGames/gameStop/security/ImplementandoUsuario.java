package com.minhaLojaDeGames.gameStop.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.minhaLojaDeGames.gameStop.model.Usuario;
import com.minhaLojaDeGames.gameStop.repository.UsuarioRepository;

/**
 * Classe voltada para a trativa de erros relacionados as credenciais de email do usuario.
 * @author usuario
 *
 */

@Service
public class ImplementandoUsuario implements UserDetailsService {

	@Autowired
	private UsuarioRepository repositorySecurityService;

	@Override
	public UserDetails loadUserByUsername(String credencialLogin) throws UsernameNotFoundException {
		Optional<Usuario> objectSecurityService = repositorySecurityService.findByEmail(credencialLogin);

		if (objectSecurityService.isPresent()) {
			return new DetalhesDeUsuario(objectSecurityService.get());

		} else {

			throw new UsernameNotFoundException(credencialLogin + " inexistente...");
		}

	}

}
