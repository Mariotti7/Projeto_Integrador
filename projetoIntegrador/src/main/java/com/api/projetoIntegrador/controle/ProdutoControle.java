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

import com.api.projetoIntegrador.modelo.ProdutoModelo;
import com.api.projetoIntegrador.repositorio.ProdutoRepositorio;

@RestController
@RequestMapping("/")
public class ProdutoControle {

	@Autowired
	private ProdutoRepositorio repositoryProduto;
	
	@GetMapping("/produtos")
	public @ResponseBody List<ProdutoModelo> findProduct(){
		return repositoryProduto.findAll();
	}
	
	@GetMapping("/produto/{id}")
	public @ResponseBody Optional<ProdutoModelo> getByProduct(@PathVariable Long id){
		return repositoryProduto.findById(id);
	}
	
	@PostMapping("/produtos")
	public @ResponseBody ProdutoModelo insertProduct(@RequestBody ProdutoModelo produto){
		return repositoryProduto.save(produto);
	}
	
	@PutMapping("/produtos/{id}")
	public ResponseEntity<ProdutoModelo> updateProduct(@PathVariable Long id, @RequestBody ProdutoModelo produto){
		return ResponseEntity.status(HttpStatus.OK).body(repositoryProduto.save(produto));
	}
	
	@DeleteMapping("/produtos/id/{id}")
	public void deleteProduct(@PathVariable Long id) {
		repositoryProduto.deleteById(id);
	}

}
