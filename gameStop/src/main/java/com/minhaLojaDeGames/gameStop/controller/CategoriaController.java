package com.minhaLojaDeGames.gameStop.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minhaLojaDeGames.gameStop.model.Categoria;
import com.minhaLojaDeGames.gameStop.repository.CategoriaRepository;

@RestController
@RequestMapping("/gamestop/v1/category")
public class CategoriaController {
	@Autowired
	private CategoriaRepository repository1;

	@GetMapping("/all")
	public ResponseEntity<List<Categoria>> GetAll() {
		List<Categoria> objectCategory = repository1.findAll();

		if (objectCategory.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objectCategory);
		}

	}

	@PostMapping("/save")
	public ResponseEntity<Categoria> salvarCategoria(@Valid @RequestBody Categoria novaCategoria) {
		return ResponseEntity.status(201).body(repository1.save(novaCategoria));
	}

	@GetMapping("/id/{category_id}")
	public ResponseEntity<Categoria> buscarIdCategoria(@PathVariable(value = "category_id") Long idCategoria) {
		Optional<Categoria> objectCategoryI = repository1.findById(idCategoria);

		if (objectCategoryI.isPresent()) {
			return ResponseEntity.status(200).body(objectCategoryI.get());

		} else {

			return ResponseEntity.status(204).build();
		}
	}

	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<Categoria>> buscarTipoI(@PathVariable(value = "acao") String classe) {
		List<Categoria> objectCategoryII = repository1.findAllByTipoContainingIgnoreCase(classe);

		if (objectCategoryII.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objectCategoryII);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Categoria> atualizar(@Valid @RequestBody Categoria atualizaCategoria) {
		return ResponseEntity.status(201).body(repository1.save(atualizaCategoria));
	}

	@DeleteMapping("/delete/{category_id}")
	public void deletarCategoria(@PathVariable(value = "category_id") Long idCategoria) {
		repository1.deleteById(idCategoria);
	}

}
