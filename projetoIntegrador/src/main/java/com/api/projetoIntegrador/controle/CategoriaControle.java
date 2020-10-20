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

import com.api.projetointegrador.modelo.CategoriaModelo;
import com.api.projetointegrador.repositorio.CategoriaRepositorio;

@RestController
@RequestMapping("/categoria")
public class CategoriaControle {

	@Autowired
	private CategoriaRepositorio repositoryCategoria;

	@GetMapping
	public ResponseEntity<List<CategoriaModelo>> findCategory() {
		return ResponseEntity.ok(repositoryCategoria.findAll());
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<CategoriaModelo>> getByCategory(@PathVariable Long id) {
		return ResponseEntity.ok(repositoryCategoria.findById(id));
	}

	@PostMapping
	public ResponseEntity<CategoriaModelo> insertCategory(@RequestBody CategoriaModelo categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryCategoria.save(categoria));
	}

	@PutMapping("/categoria/{id}")
	public ResponseEntity<CategoriaModelo> updateCategory(@PathVariable Long id,
			@RequestBody CategoriaModelo categoria) {
		categoria.setId_categoria(id);
		return ResponseEntity.status(HttpStatus.OK).body(repositoryCategoria.save(categoria));
	}

	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		repositoryCategoria.deleteById(id);
	}
}
