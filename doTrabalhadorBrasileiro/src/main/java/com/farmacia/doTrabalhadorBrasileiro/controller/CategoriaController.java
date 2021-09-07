package com.farmacia.doTrabalhadorBrasileiro.controller;

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

import com.farmacia.doTrabalhadorBrasileiro.model.Categoria;
import com.farmacia.doTrabalhadorBrasileiro.repository.CategoriaRepository;

@RestController
@RequestMapping("/farmaciadotrabalhador/v1/category")
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
	public ResponseEntity<Categoria> salvarCategoria(@Valid @RequestBody Categoria salvando) {
		return ResponseEntity.status(201).body(repository1.save(salvando));
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Categoria> buscarId(@PathVariable(value = "id") Long procuraId) {
		Optional<Categoria> objectCategoryI = repository1.findById(procuraId);

		if (objectCategoryI.isPresent()) {
			return ResponseEntity.status(200).body(objectCategoryI.get());

		} else {

			return ResponseEntity.status(204).build();
		}
	}

	@GetMapping("/remedycategory/{categoriaRemedio}")
	public ResponseEntity<List<Categoria>> buscarTipo(@PathVariable(value = "categoriaRemedio") String buscaRemedio) {
		List<Categoria> objectCategoryII = repository1.findAllByCategoriaRemedioContainingIgnoreCase(buscaRemedio);

		if (objectCategoryII.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objectCategoryII);
		}
	}

	@GetMapping("/formaremedio/{formaRemedio}")
	public ResponseEntity<List<Categoria>> buscarTipoII(@PathVariable(value = "formaRemedio") String buscaForma) {
		List<Categoria> objectCategoryIII = repository1.findAllByFormaRemedioContainingIgnoreCase(buscaForma);

		if (objectCategoryIII.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objectCategoryIII);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Categoria> atualizaCategoria(@Valid @RequestBody Categoria atualiza) {
		return ResponseEntity.status(201).body(repository1.save(atualiza));
	}

	@DeleteMapping("/delete/{id}")
	public void deletaCategoria(@PathVariable(value = "id") Long deleta) {
		repository1.deleteById(deleta);
	}

}
