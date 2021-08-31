package com.farmacia.doTrabalhadorBrasileiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.doTrabalhadorBrasileiro.model.Categoria;

/**
 * Metódo utilizado para se fazer pesquisas na coluna "categoriaRemedio" e "formaRemedio" ContainingIgnoreCase
 * @param categoriaRemedio e formaRemedio são do tipo String
 * @return List de categoria
 * @author Cristiano 
 * 
 */

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> 
{
	List<Categoria> findAllByCategoriaRemedioContainingIgnoreCase(String categoriaRemedio);
	List<Categoria> findAllByFormaRemedioContainingIgnoreCase(String formaRemedio);
}
