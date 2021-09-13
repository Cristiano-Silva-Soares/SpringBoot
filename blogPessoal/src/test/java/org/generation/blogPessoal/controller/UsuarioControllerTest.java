package org.generation.blogPessoal.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UsuarioControllerTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	private Usuario criarUsuario;
	private Usuario alterarUsuario;
	@Autowired
	private TestRestTemplate testRestTemplate;

	@BeforeEach
	void start() {

		alterarUsuario = new Usuario(0L, "Digo", "rodrigoeu@email.com", "12345678");
		if (!usuarioRepository.findByEmail(alterarUsuario.getEmail()).isPresent()) {
			HttpEntity<Usuario> request = new HttpEntity<Usuario>(alterarUsuario);
			testRestTemplate.exchange("/prototype/blog/users/salvar", HttpMethod.POST, request, Usuario.class);
		}
		criarUsuario = new Usuario(1L, "Cristiano", "cristianoeu@email.com", "123456");
	}

	@Test
	@Order(1)
	void saveNewUserInBankReturnStatus201() {
		HttpEntity<Usuario> request = new HttpEntity<Usuario>(criarUsuario);
		ResponseEntity<Usuario> response = testRestTemplate.exchange("/prototype/blog/users/salvar", HttpMethod.POST,
				request, Usuario.class);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}

	@Test
	@Order(2)
	void findAllReturnStatus200() {
		ResponseEntity<String> response = testRestTemplate.withBasicAuth("rodrigoeu@email.com", "12345678")
				.exchange("/prototype/blog/users/allusers", HttpMethod.GET, null, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@Order(3)
	public void deveRealizarPutUsuario() {
		HttpEntity<Usuario> request = new HttpEntity<Usuario>(alterarUsuario);
		ResponseEntity<Usuario> resposta = testRestTemplate.withBasicAuth("rodrigoeu@email.com", "12345678")
				.exchange("/prototype/blog/users/atualizar", HttpMethod.PUT, request, Usuario.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}

}
