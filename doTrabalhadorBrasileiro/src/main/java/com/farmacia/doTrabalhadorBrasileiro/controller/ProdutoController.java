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

import com.farmacia.doTrabalhadorBrasileiro.model.Produto;
import com.farmacia.doTrabalhadorBrasileiro.repository.ProdutoRepository;

@RestController
@RequestMapping("/farmaciadotrabalhador/v1/product")
public class ProdutoController {
	@Autowired
	private ProdutoRepository repository2;

	@GetMapping("/all")
	public ResponseEntity<List<Produto>> GetAll() {
		List<Produto> objectProduct = repository2.findAll();

		if (objectProduct.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objectProduct);
		}
	}

	@PostMapping("/save")
	public ResponseEntity<Produto> salvaProduto(@Valid @RequestBody Produto salvando) {
		return ResponseEntity.status(201).body(repository2.save(salvando));
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Produto> buscarId(@PathVariable(value = "id") Long idProduto) {
		Optional<Produto> objectProductI = repository2.findById(idProduto);

		if (objectProductI.isPresent()) {
			return ResponseEntity.status(200).body(objectProductI.get());

		} else {

			return ResponseEntity.status(204).build();
		}
	}
	
	@GetMapping("/nomeproduto/{nomeProduto}")
	public ResponseEntity<List<Produto>> buscaNome(@PathVariable(value = "nomeProduto")String nome) {
		List<Produto> objectProductII = repository2.pesquisarProdutos(nome);
		
		if(objectProductII.isEmpty()) {
			return ResponseEntity.status(204).build();
			
		} else {
			
			return ResponseEntity.status(200).body(objectProductII);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<Produto> atualizandoProduto(@Valid@RequestBody Produto atualiza) {
		return ResponseEntity.status(201).body(repository2.save(atualiza));
	}
	
	@DeleteMapping("delete/{id}")
		public void deletaProduto(@PathVariable(value = "id")Long idProduto) {
			repository2.deleteById(idProduto);
	}
	

}
