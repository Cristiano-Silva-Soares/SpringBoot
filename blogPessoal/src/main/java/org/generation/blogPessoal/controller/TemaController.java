package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Tema;
import org.generation.blogPessoal.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prototype/blog/theme")
public class TemaController 
{
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

}
