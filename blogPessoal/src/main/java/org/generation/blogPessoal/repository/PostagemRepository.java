package org.generation.blogPessoal.repository;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Metódo utilizado para se fazer pesquisas na coluna "titulo" ContainingIgnoreCase
 * @param título do tipo String
 * @return List de Postagens
 * @author Cristiano 
 * 
 */

@Repository
public interface PostagemRepository extends JpaRepository<Postagem,Long> 
{
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);
}
