package com.farmacia.doTrabalhadorBrasileiro.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.farmacia.doTrabalhadorBrasileiro.model.Usuario;
import com.farmacia.doTrabalhadorBrasileiro.model.utilities.UsuarioEspelho;
import com.farmacia.doTrabalhadorBrasileiro.repository.UsuarioRepository;

@Service
public class UsuarioServico {
	@Autowired
	private UsuarioRepository repository4;

	public Optional<Object> cadastrarUsuarios(Usuario novosUsuarios) {
		return repository4.findByEmail(novosUsuarios.getEmail()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String result = encoder.encode(novosUsuarios.getSenha());
			novosUsuarios.setSenha(result);
			return Optional.ofNullable(repository4.save(novosUsuarios));
		});

	}

	public Optional<?> fazerLogin(UsuarioEspelho usuarioParaLogin) {
		return repository4.findByEmail(usuarioParaLogin.getEmail()).map(usuarioCadastrado -> {
			BCryptPasswordEncoder criptografa = new BCryptPasswordEncoder();

			if (criptografa.matches(usuarioParaLogin.getSenha(), usuarioCadastrado.getSenha())) {

				String estruturaLiteral = usuarioParaLogin.getEmail() + ":" + usuarioParaLogin.getSenha();
				byte[] estruturaBase = Base64.encodeBase64(estruturaLiteral.getBytes(Charset.forName("US-ASCII")));
				String tokenGerado = "Basic " + new String(estruturaBase);

				usuarioParaLogin.setToken(tokenGerado);
				usuarioParaLogin.setIdUsuario(usuarioCadastrado.getIdUsuario());
				usuarioParaLogin.setNomeUsuario(usuarioCadastrado.getNomeUsuario());
				usuarioParaLogin.setEmail(usuarioCadastrado.getEmail());
				usuarioParaLogin.setSenha(usuarioCadastrado.getSenha());
				return Optional.ofNullable(usuarioParaLogin);

			} else {

				return Optional.empty();
			}

		}).orElseGet(() -> {

			return Optional.empty();
		});

	}

}
