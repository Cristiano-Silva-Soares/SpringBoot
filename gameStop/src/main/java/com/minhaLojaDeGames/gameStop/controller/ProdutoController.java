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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minhaLojaDeGames.gameStop.model.Produto;
import com.minhaLojaDeGames.gameStop.repository.ProdutoRepository;

@RestController
@RequestMapping("/gamestop/v1/product")
public class ProdutoController {
	@Autowired
	private ProdutoRepository repository2;

	@GetMapping("/all")
	public ResponseEntity<List<Produto>> getAll() {
		List<Produto> objectProduct = repository2.findAll();

		if (objectProduct.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objectProduct);
		}

	}

	@PostMapping("/save")
	public ResponseEntity<Produto> salvar(@Valid @RequestBody Produto salvaProduto) {
		return ResponseEntity.status(201).body(repository2.save(salvaProduto));
	}

	@GetMapping("/id/{id_produto}")
	public ResponseEntity<Produto> buscarIdProduto(@PathVariable(value = "id_produto") Long idProduto) {
		Optional<Produto> objectProductI = repository2.findById(idProduto);

		if (objectProductI.isPresent()) {
			return ResponseEntity.status(200).body(objectProductI.get());

		} else {

			return ResponseEntity.status(204).build();
		}
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<List<Produto>> buscarNomeProduto(@PathVariable(value = "name") String nome) {
		List<Produto> objectProductII = repository2.findAllByNomeContainingIgnoreCase(nome);

		if (objectProductII.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objectProductII);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Produto> atualizar(@Valid @RequestBody Produto atualizaProduto) {
		return ResponseEntity.status(201).body(repository2.save(atualizaProduto));
	}

	@DeleteMapping("/delete/{id_product}")
	public void deletaProduto(@PathVariable(value = "id_product") Long idProduto) {
		repository2.deleteById(idProduto);
	}

}
