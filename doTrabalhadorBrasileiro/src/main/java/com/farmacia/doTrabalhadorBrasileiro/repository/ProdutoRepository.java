package com.farmacia.doTrabalhadorBrasileiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.farmacia.doTrabalhadorBrasileiro.model.Produto;

/**
 * Metódo utilizado para se fazer pesquisas na coluna "nomeProduto" ContainingIgnoreCase
 * @param nomeProduto do tipo String
 * @return List de Produto
 * @author Cristiano 
 * 
 */

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>
{
	//List<Produto>findAllByNomeRemedioContainingIgnoreCase(String nomeProduto);
	
	@Query("from Produto where nomeRemedio like concat(?1, '%')")
	public List<Produto> pesquisarProdutos(String nomeRemedio);
}
