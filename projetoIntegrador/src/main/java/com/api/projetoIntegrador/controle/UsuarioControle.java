package com.api.projetoIntegrador.controle;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.projetoIntegrador.modelo.UsuarioModelo;
import com.api.projetoIntegrador.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControle {

	@Autowired
	private UsuarioRepositorio repositoryUsuario;

	@GetMapping
	public @ResponseBody List<UsuarioModelo> findUsers() {
		return repositoryUsuario.findAll();
	}

	@GetMapping("/{id}")
	public @ResponseBody Optional<UsuarioModelo> getByUser(@PathVariable Long id) {
		return repositoryUsuario.findById(id);
	}

	@PostMapping
	public @ResponseBody UsuarioModelo insertUser(@RequestBody UsuarioModelo usuario) {
		return repositoryUsuario.save(usuario);
	}

	@PutMapping("/id/{id}")
	public ResponseEntity<UsuarioModelo> updateUser(@PathVariable Long id, @RequestBody UsuarioModelo usuario) {
		return ResponseEntity.status(HttpStatus.OK).body(repositoryUsuario.save(usuario));
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		repositoryUsuario.deleteById(id);
	}
}
