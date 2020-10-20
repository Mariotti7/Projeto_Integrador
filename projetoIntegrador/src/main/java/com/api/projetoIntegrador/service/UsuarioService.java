package com.api.projetointegrador.service;

import java.nio.charset.Charset;
import org.apache.commons.codec.binary.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.projetointegrador.modelo.UsuarioLogin;
import com.api.projetointegrador.modelo.UsuarioModelo;
import com.api.projetointegrador.repositorio.UsuarioRepositorio;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepositorio repository;

	public UsuarioModelo CadastrarUsuario(UsuarioModelo email) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaEncoder = encoder.encode(email.getSenha());
		email.setSenha(senhaEncoder);

		return repository.save(email);
	}

	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<UsuarioModelo> usuario = repository.findByEmail(user.get().getEmail());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {

				String auth = user.get().getEmail() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setToken(authHeader);
				user.get().setNome(usuario.get().getNome());
				return user;
			}
		}
		return null;
	}
}
