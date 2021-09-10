package com.minhaLojaDeGames.gameStop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhaLojaDeGames.gameStop.model.Usuario;

/**
 * Interface criada com intuito de buscar o nome do usuário cadastrado dentro do
 * sistema com ContainingIgnoreCase.
 * 
 * @author Cristiano
 * @since 1.5
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public List<Usuario> findAllByNomeUsuarioContainingIgnoreCase(String nomeUsuario);

	/**
	 * Metódo Utilizado para achar o e-mail cadastardo pelo usuario.
	 * 
	 * @param Optional tipo findByEmail
	 * @return String email
	 * @author Cristiano
	 * @since 1.5
	 */

	Optional<Usuario> findByEmail(String email);
}
