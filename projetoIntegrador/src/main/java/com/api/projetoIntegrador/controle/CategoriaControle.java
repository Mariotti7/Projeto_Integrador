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

import com.api.projetoIntegrador.modelo.CategoriaModelo;
import com.api.projetoIntegrador.repositorio.CategoriaRepositorio;

@RestController
@RequestMapping("/categoria")
public class CategoriaControle {

	@Autowired
	private CategoriaRepositorio repositoryCategoria;

	@GetMapping
	public @ResponseBody List<CategoriaModelo> findCategory() {
		return repositoryCategoria.findAll();
	}

	@GetMapping("/{id}")
	public @ResponseBody Optional<CategoriaModelo> getByCategory(@PathVariable Long id) {
		return repositoryCategoria.findById(id);
	}

	@PostMapping
	public @ResponseBody CategoriaModelo insertCategory(@RequestBody CategoriaModelo categoria) {
		return repositoryCategoria.save(categoria);
	}

	@PutMapping("/id/{id}")
	public ResponseEntity<CategoriaModelo> updateCategory(@PathVariable Long id,
			@RequestBody CategoriaModelo categoria) {
		return ResponseEntity.status(HttpStatus.OK).body(repositoryCategoria.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Long id) {
		repositoryCategoria.deleteById(id);
	}
}
