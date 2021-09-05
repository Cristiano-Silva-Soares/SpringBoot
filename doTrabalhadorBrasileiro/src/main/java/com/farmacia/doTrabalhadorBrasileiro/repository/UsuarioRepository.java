package com.farmacia.doTrabalhadorBrasileiro.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.farmacia.doTrabalhadorBrasileiro.model.Usuario;

/**
 * Metódo utilizado para se fazer pesquisas na coluna "nomeUsuario" ContainingIgnoreCase
 * @param nomeUsuario do tipo String
 * @return List de Usuario
 * @author Cristiano 
 * 
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>
{
	@Query("from Usuario where nomeUsuario like conkat(?1  '%')")
	public List<Usuario> pesquisaUsuario(String nomeUsuario);
	
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
