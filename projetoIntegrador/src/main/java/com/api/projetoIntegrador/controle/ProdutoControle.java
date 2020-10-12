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
import org.springframework.web.bind.annotation.RestController;

import com.api.projetoIntegrador.modelo.ProdutoModelo;
import com.api.projetoIntegrador.repositorio.ProdutoRepositorio;

@RestController
@RequestMapping("/produto")
public class ProdutoControle {

	@Autowired
	private ProdutoRepositorio repositoryProduto;
	
	@GetMapping
	public ResponseEntity<List<ProdutoModelo>> findProduct(){
		return ResponseEntity.ok(repositoryProduto.findAll());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<ProdutoModelo>> getByProduct(@PathVariable Long id){
		return ResponseEntity.ok(repositoryProduto.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoModelo> insertProduct(@RequestBody ProdutoModelo produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryProduto.save(produto));
	}
	
	@PutMapping("/produto/{id}")
	public ResponseEntity<ProdutoModelo> updateProduct(@PathVariable Long id, @RequestBody ProdutoModelo produto){
		produto.setId_produto(id);
		return ResponseEntity.status(HttpStatus.OK).body(repositoryProduto.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		repositoryProduto.deleteById(id);
	}

}
