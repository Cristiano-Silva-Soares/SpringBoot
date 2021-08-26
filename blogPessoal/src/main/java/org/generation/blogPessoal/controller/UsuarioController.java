package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prototype/blog/users")
public class UsuarioController 
{
	@Autowired
	private UsuarioRepository repository2;
	
	@GetMapping("/allusers")
	public ResponseEntity<List<Usuario>> GetAll(){
		List<Usuario> objetoUsers = repository2.findAll();
		
		if(objetoUsers.isEmpty()) {
			
			return ResponseEntity.status(204).build();
		
		} else {
			
			return ResponseEntity.status(200).body(objetoUsers);
		}
	}
		
	
	
	
}
