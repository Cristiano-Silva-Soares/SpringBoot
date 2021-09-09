package com.minhaLojaDeGames.gameStop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minhaLojaDeGames.gameStop.repository.UsuarioRepository;

@RestController
@RequestMapping("/gamestop/v1/user")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository3;
	
	@GetMapping("/all")
	private ResponseEntity<List<Usuario>> getAll() {
		
	}

}
