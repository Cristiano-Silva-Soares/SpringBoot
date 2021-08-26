package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Metódo utilizado para se fazer pesquisas na coluna "tema" ContainingIgnoreCase
 * @param nomeUsuario do tipo String
 * @return List de Usuarios
 * @author Cristiano
 * 
 */

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario,Long>
{
	public List<Usuario>findAllByNomeUsuarioContainingIgnoreCase(String nomeUsuario);
}
