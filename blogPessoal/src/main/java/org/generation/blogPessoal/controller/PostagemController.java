package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagem")
public class PostagemController 
{
		@Autowired
		private PostagemRepository repository1;
		
		@GetMapping
		public ResponseEntity<List<Postagem>> GetAll()
		{
			return ResponseEntity.ok(repository1.findAll());
		}	
}
