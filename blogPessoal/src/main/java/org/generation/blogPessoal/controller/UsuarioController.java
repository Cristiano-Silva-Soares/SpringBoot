package org.generation.blogPessoal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.model.utilities.UsuarioDTO;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.generation.blogPessoal.servicos.UsuarioServicos;
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
@RequestMapping("/prototype/blog/users")
public class UsuarioController {
	@Autowired
	private UsuarioRepository repository2;
	@Autowired
	private UsuarioServicos repository4;

	@GetMapping("/allusers")
	public ResponseEntity<List<Usuario>> GetAll() {
		List<Usuario> objetoUsers = repository2.findAll();

		if (objetoUsers.isEmpty()) {

			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objetoUsers);
		}
	}

	@PostMapping("/salvar")
	public ResponseEntity<Object> salvar(@Valid @RequestBody Usuario novoUsuario) {
		Optional<Object> objectOptionalI = repository4.cadastrarUsuario(novoUsuario);

		if (objectOptionalI.isEmpty()) {
			return ResponseEntity.status(400).build();

		} else {

			return ResponseEntity.status(201).body(objectOptionalI.get());
		}
	}

	@PutMapping("/credenciais")
	public ResponseEntity<Object> credenciaisUsuario(@Valid @RequestBody UsuarioDTO usuarioParaAutenticar) {
		Optional<?> objectOptionalII = repository4.pegarCredenciaisUsuario(usuarioParaAutenticar);

		if (objectOptionalII.isEmpty()) {
			return ResponseEntity.status(400).build();

		} else {

			return ResponseEntity.status(201).body(objectOptionalII.get());
		}
	}

	@GetMapping("/{id_usuario}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable(value = "id_usuario") Long idUsuario) {
		Optional<Usuario> objetoUsersI = repository2.findById(idUsuario);

		if (objetoUsersI.isPresent()) {
			return ResponseEntity.status(200).body(objetoUsersI.get());

		} else {

			return ResponseEntity.status(204).build();
		}
	}

	@GetMapping("/nome/{nome_usuario}")
	public ResponseEntity<List<Usuario>> buscaPorNomeI(@PathVariable(value = "nome_usuario") String nome) {
		List<Usuario> objetoUsersII = repository2.findAllByNomeUsuarioContainingIgnoreCase(nome);

		if (objetoUsersII.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objetoUsersII);
		}
	}

	@GetMapping("/pesquisa")
	public ResponseEntity<List<Usuario>> buscaPorNomeII(@RequestParam(defaultValue = "") String nome) {
		List<Usuario> objetoUsersIII = repository2.findAllByNomeUsuarioContainingIgnoreCase(nome);

		if (objetoUsersIII.isEmpty()) {
			return ResponseEntity.status(204).build();

		} else {

			return ResponseEntity.status(200).body(objetoUsersIII);
		}

	}

	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> atualizar(@Valid @RequestBody Usuario usuarioParaAtualizar) {
		return ResponseEntity.status(201).body(repository2.save(usuarioParaAtualizar));
	}

	@DeleteMapping("/deletar/{id_usuario}")
	public void deletarUsuarioPorId(@PathVariable(value = "id_usuario") Long idUsuario) {
		repository2.deleteById(idUsuario);
	}

}
