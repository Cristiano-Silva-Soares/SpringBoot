package org.generation.blogPessoal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.generation.blogPessoal.model.Tema;
import org.generation.blogPessoal.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prototype/blog/theme")
public class TemaController {
	@Autowired
	private TemaRepository repository3;

	@GetMapping("/allthemes")
	public ResponseEntity<List<Tema>> GetAll() {
		List<Tema> objetoTheme = repository3.findAll();

		if (objetoTheme.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objetoTheme);
		}
	}

	@PostMapping("/salvar")
	public ResponseEntity<Tema> salvar(@Valid @RequestBody Tema novoTema) {
		return ResponseEntity.status(201).body(repository3.save(novoTema));
	}

	@GetMapping("/{id_tema}")
	public ResponseEntity<Tema> buscarIdTema(@PathVariable(value = "id_tema") Long idTema) {
		Optional<Tema> objetoThemeI = repository3.findById(idTema);

		if (objetoThemeI.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objetoThemeI.get());

		}
	}

	@GetMapping("/tema/{tema}")
	public ResponseEntity<List<Tema>> buscaPorTema(@PathVariable(value = "tema") String tema) {
		List<Tema> objetoThemeII = repository3.findAllByTemaContainingIgnoreCase(tema);

		if (objetoThemeII.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objetoThemeII);
		}
	}

	@GetMapping("/pesquisa")
	public ResponseEntity<Tema> atualizar(@Valid @RequestBody Tema temaParaAtualizar) {
		return ResponseEntity.status(201).body(repository3.save(temaParaAtualizar));
	}

	@DeleteMapping("/delete/{id_Tema}")
	public void deletarTemaPorId(@PathVariable(value = "id_tema") Long idTema) {
		repository3.deleteById(idTema);
	}
}
