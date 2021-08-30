package com.minhaLojaDeGames.gameStop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhaLojaDeGames.gameStop.model.Produto;

/**
 * Metódo usado para pesquisar o nome dos jogos.
 * @param nome do tipo String.
 * @author Cristiano.
 * @return List de nomes dos jogos.
 * 
 */

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>
{
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	public List<Produto> findAllByNovo(boolean novo);
}
