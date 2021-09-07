package com.farmacia.doTrabalhadorBrasileiro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.doTrabalhadorBrasileiro.model.Usuario;

/**
 * Metódo utilizado para se fazer pesquisas na coluna "nomeUsuario"
 * ContainingIgnoreCase
 * 
 * @param nomeUsuario do tipo String
 * @return List de Usuario
 * @author Cristiano
 * 
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public List<Usuario> findAllByNomeUsuarioContainingIgnoreCase (String nomeUsuario);

	/**
	 * Método utilizado para pesquisar coluna Email
	 * 
	 * @param email do tipo String
	 * @return Optional com Usuario
	 * @author Cristiano
	 * @since 1.0
	 * 
	 */

	Optional<Usuario> findByEmail(String email);

}
