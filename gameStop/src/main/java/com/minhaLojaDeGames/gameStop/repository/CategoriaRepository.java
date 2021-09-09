package com.minhaLojaDeGames.gameStop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minhaLojaDeGames.gameStop.model.Categoria;

/**
 * Metódos usados para se fazer pesquisas dentro da categoria ação,rpg, e etc;
 * com containingIgnoreCase(pesquisa livre na questão dos caracteres).
 * 
 * @Param catgeorias de ação,rpg,e esporte/corrida.
 * @return Lista de ação,rpg,e esporte/corrida.
 * @author Cristiano
 * @since 1.0
 *
 */

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	public List<Categoria> findAllByTipoContainingIgnoreCase(String Tipo);
}
