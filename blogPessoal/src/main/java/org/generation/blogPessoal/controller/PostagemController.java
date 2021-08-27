package org.generation.blogPessoal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prototype/blog/post")
public class PostagemController {
	@Autowired
	private PostagemRepository repository1;

	@GetMapping("/allposts")
	public ResponseEntity<List<Postagem>> GetAll() {
		List<Postagem> objetoPost = repository1.findAll();

		if (objetoPost.isEmpty()) {

			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objetoPost);
		}
	}

	@PostMapping("/salvar")
	public ResponseEntity<Postagem> salvar(@Valid @RequestBody Postagem novaPostagem) {
		return ResponseEntity.status(201).body(repository1.save(novaPostagem));
	}

	@GetMapping("/{id_postagem}")
	public ResponseEntity<Postagem> buscarPorId(@PathVariable(value = "id_postagem") Long idPostagem) {
		Optional<Postagem> objetoPostI = repository1.findById(idPostagem);

		if (objetoPostI.isPresent()) {
			return ResponseEntity.status(200).body(objetoPostI.get());

		} else {

			return ResponseEntity.status(204).build();
		}
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> buscaPorTituloI(@PathVariable(value = "titulo") String titulo) {
		List<Postagem> objetoPostII = repository1.findAllByTituloContainingIgnoreCase(titulo);

		if (objetoPostII.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objetoPostII);
		}
	}

	@GetMapping("/pesquisa")
	public ResponseEntity<List<Postagem>> buscarPorTituloII(@RequestParam(defaultValue = "") String titulo) {
		List<Postagem> objetoPostIII = repository1.findAllByTituloContainingIgnoreCase(titulo);

		if (objetoPostIII.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objetoPostIII);
		}
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Postagem> atualizar(@Valid @RequestBody Postagem postagemParaAtualizar) {
		return ResponseEntity.status(201).body(repository1.save(postagemParaAtualizar));
	}

	@DeleteMapping("/delete/{id_Postagem}")
	public void deletarPostagemPorId(@PathVariable(value = "id_Postagem") long idPostagem) {
		repository1.deleteById(idPostagem);
	}

}
