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

import com.minhaLojaDeGames.gameStop.model.Usuario;
import com.minhaLojaDeGames.gameStop.model.utilities.UsuarioEspelho;
import com.minhaLojaDeGames.gameStop.repository.UsuarioRepository;
import com.minhaLojaDeGames.gameStop.services.UsuarioServicos;

@RestController
@RequestMapping("/gamestop/v1/user")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository3;
	@Autowired
	private UsuarioServicos repository4;

	@GetMapping("/all")
	private ResponseEntity<List<Usuario>> getAll() {
		List<Usuario> objectUsers = repository3.findAll();

		if (objectUsers.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objectUsers);
		}

	}

	@PostMapping("/save")
	public ResponseEntity<Object> cadastroUsuario(@Valid @RequestBody Usuario salvaUsuario) {
		Optional<Object> objectCadastra = repository4.cadastroUsuario(salvaUsuario);

		if (objectCadastra.isEmpty()) {
			return ResponseEntity.status(400).build();

		} else {

			return ResponseEntity.status(200).body(objectCadastra.get());
		}

	}

	@PutMapping("/login")
	public ResponseEntity<Object> logar(@Valid @RequestBody UsuarioEspelho usuarioSalvo) {
		Optional<?> objectLogin = repository4.fazerLogin(usuarioSalvo);

		if (objectLogin.isEmpty()) {
			return ResponseEntity.status(400).build();

		} else {

			return ResponseEntity.status(200).body(objectLogin.get());
		}
	}

	@GetMapping("/searchid/{id_usuario}")
	public ResponseEntity<Usuario> buscarIdUsuario(@PathVariable(value = "id_usuario") Long buscaUsuario) {
		Optional<Usuario> objectSearch = repository3.findById(buscaUsuario);

		if (objectSearch.isPresent()) {
			return ResponseEntity.status(200).body(objectSearch.get());

		} else {

			return ResponseEntity.status(204).build();
		}
	}

	@GetMapping("/searchname/{nome_usuario}")
	public ResponseEntity<List<Usuario>> buscaNome(@PathVariable(value = "nome_usuario") String usuarioNome) {
		List<Usuario> objectName = repository3.findAllByNomeUsuarioContainingIgnoreCase(usuarioNome);

		if (objectName.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objectName);
		}

	}

	@PutMapping("/update")
	public ResponseEntity<Usuario> atualizar(@Valid @RequestBody Usuario atualizaUsuario) {
		return ResponseEntity.status(201).body(repository3.save(atualizaUsuario));
	}

	@DeleteMapping("/delete/{id_usuario}")
	public void deletaUsuario(@PathVariable(value = "id_usuario") Long usuarioId) {
		repository3.deleteById(usuarioId);
	}

}
