package com.minhaLojaDeGames.gameStop.services;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.minhaLojaDeGames.gameStop.model.Usuario;
import com.minhaLojaDeGames.gameStop.model.utilities.UsuarioEspelho;
import com.minhaLojaDeGames.gameStop.repository.UsuarioRepository;

/**
 * Classe criada para a implementação de metodos de segurança que serão
 * reepassados para a classe controller.
 * 
 * @author Cristiano
 * @Since 1.0
 *
 */

@Service
public class UsuarioServicos {
	@Autowired
	private UsuarioRepository repositoryService;

	/**
	 * Metódo criado para busca de email e criptografia de senha do usuário.
	 * 
	 * @param Optional do tipo Object 'cadastroUsuario'
	 * @return Optional não nulo com a senha encriptada
	 * 
	 */

	public Optional<Object> cadastroUsuario(Usuario usuarioNovo) {
		return repositoryService.findByEmail(usuarioNovo.getEmail()).map(usuarioCadastrado -> {
			return Optional.empty();
		}).orElseGet(() -> {
			BCryptPasswordEncoder criptografa = new BCryptPasswordEncoder();
			String criptografaSenha = criptografa.encode(usuarioNovo.getSenha());
			usuarioNovo.setSenha(criptografaSenha);
			return Optional.ofNullable(repositoryService.save(usuarioNovo));
		});
	}

	/**
	 * Metódo criado com o íntuito de gera um token encriptado para o acesso do
	 * usuario atráves de seu login no sistema.
	 * 
	 * @param Optional do tipo ?(a interrogração se faz presente por conta da
	 * possibilidade de haver mais de um retorno para o metódo)
	 * @return token de acesso e todas as informações cedidas pelo usuario na hora
	 * do cadastro
	 */

	public Optional<?> fazerLogin(UsuarioEspelho usuarioLogin) {
		return repositoryService.findByEmail(usuarioLogin.getEmail()).map(usuarioCadastrado -> {
			BCryptPasswordEncoder criptografa = new BCryptPasswordEncoder();

			if (criptografa.matches(usuarioLogin.getSenha(), usuarioCadastrado.getSenha())) {

				String estruturaLiteral = usuarioLogin.getEmail() + ":" + usuarioLogin.getEmail();
				byte[] estruturaBasica = Base64.encodeBase64(estruturaLiteral.getBytes(Charset.forName("US-ASCII")));
				String tokenGerado = "Basic " + new String(estruturaBasica);

				usuarioLogin.setToken(tokenGerado);
				usuarioLogin.setIdUsuario(usuarioCadastrado.getIdUsuario());
				usuarioLogin.setNomeUsuario(usuarioCadastrado.getNomeUsuario());
				usuarioLogin.setEmail(usuarioCadastrado.getEmail());
				usuarioLogin.setSenha(usuarioCadastrado.getSenha());
				return Optional.ofNullable(usuarioLogin);

			} else {

				return Optional.empty(); // Caso o email digitado esteja incorreto ou fora do sistema.
			}

		}).orElseGet(() -> {

			return Optional.empty(); // Caso a senha digitada esteja incorreta ou fora do sistema.
		});

	}
}
