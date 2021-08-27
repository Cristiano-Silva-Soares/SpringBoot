package org.generation.blogPessoal.servicos;

import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicos 
{
	@Autowired 
	private UsuarioRepository repository4;
	
	/**
	 * Método utilizado para a criação de um novo usuario no sistema
	 * 
	 * @param novoUsuario do tipo Usuario
	 * @return Optional com um Usuario Criado
	 * @author Cristiano
	 * @since prototype
	 * 
	 */
	public Optional<Object> cadastrarUsuario(Usuario novoUsuario) {
		return repository4.findByEmail(novoUsuario.getEmail()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			return Optional.ofNullable(repository4.save(novoUsuario));
		});
	}
}
