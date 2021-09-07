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

import com.farmacia.doTrabalhadorBrasileiro.model.Usuario;
import com.farmacia.doTrabalhadorBrasileiro.model.utilities.UsuarioEspelho;
import com.farmacia.doTrabalhadorBrasileiro.repository.UsuarioRepository;
import com.farmacia.doTrabalhadorBrasileiro.service.UsuarioServico;

@RestController
@RequestMapping("/farmaciadotrabalhador/v1/users")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository3;
	@Autowired
	private UsuarioServico repository4;

	@GetMapping("/all")
	private ResponseEntity<List<Usuario>> GetAll() {
		List<Usuario> objectUser = repository3.findAll();

		if (objectUser.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objectUser);
		}

	}

	@PostMapping("/save")
	private ResponseEntity<Object> salvaUsuario(@Valid @RequestBody Usuario novoUsuario) {
		Optional<Object> objectUserI = repository4.cadastrarUsuarios(novoUsuario);

		if (objectUserI.isEmpty()) {
			return ResponseEntity.status(400).build();

		} else {

			return ResponseEntity.status(201).body(objectUserI.get());
		}
	}

	@PutMapping("/login")
	private ResponseEntity<Object> logarUsuario(@Valid @RequestBody UsuarioEspelho logarUsuario) {
		Optional<?> objectOptionalI = repository4.fazerLogin(logarUsuario);

		if (objectOptionalI.isEmpty()) {
			return ResponseEntity.status(400).build();
		} else {

			return ResponseEntity.status(201).body(objectOptionalI.get());
		}

	}

	@GetMapping("/id/{id_usuario}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable(value = "id_usuario") Long buscaUsuario) {
		Optional<Usuario> objectOptionalIII = repository3.findById(buscaUsuario);

		if (objectOptionalIII.isPresent()) {
			return ResponseEntity.status(200).body(objectOptionalIII.get());

		} else {

			return ResponseEntity.status(204).build();
		}

	}

	@GetMapping("/name/{name_usuario}")
	public ResponseEntity<List<Usuario>> buscarPorNome(@PathVariable(value = "nome_usuario") String nomeUsuario) {
		List<Usuario> objectUserII = repository3.findAllByNomeUsuarioContainingIgnoreCase(nomeUsuario);

		if (objectUserII.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objectUserII);
		}

	}

	@PutMapping("/update")
	public ResponseEntity<Usuario> atualizaUsuario(@Valid @RequestBody Usuario informacaoNova) {
		return ResponseEntity.status(201).body(repository3.save(informacaoNova));
	}

	@DeleteMapping("/delete/{usuario_id}")
	public void deletaPerfil(@PathVariable(value = "usuario_id") Long idUsuario) {
		repository3.deleteById(idUsuario);
	}

}
