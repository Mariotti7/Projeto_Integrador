package com.api.projetointegrador.controle;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.projetointegrador.modelo.UsuarioLogin;
import com.api.projetointegrador.modelo.UsuarioModelo;
import com.api.projetointegrador.repositorio.UsuarioRepositorio;
import com.api.projetointegrador.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioControle {

	@Autowired
	private UsuarioRepositorio repositoryUsuario;
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioModelo> Post(@RequestBody UsuarioModelo usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.CadastrarUsuario(usuario));
	}

	@GetMapping
	public ResponseEntity<List<UsuarioModelo>> findUsers() {
		return ResponseEntity.ok(repositoryUsuario.findAll());
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<UsuarioModelo>> getByUser(@PathVariable Long id) {
		return ResponseEntity.ok(repositoryUsuario.findById(id));
	}

	@PostMapping
	public ResponseEntity<UsuarioModelo> insertUser(@RequestBody UsuarioModelo usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryUsuario.save(usuario));
	}

	@PutMapping("/usuario/{id}")
	public ResponseEntity<UsuarioModelo> updateUser(@PathVariable Long id, @RequestBody UsuarioModelo usuario) {
		usuario.setId_usuario(id);
		return ResponseEntity.status(HttpStatus.OK).body(repositoryUsuario.save(usuario));
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		repositoryUsuario.deleteById(id);
	}
}
