package com.api.projetoIntegrador.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.api.projetoIntegrador.modelo.CategoriaModelo;
import com.api.projetoIntegrador.repositorio.CategoriaRepositorio;

@Controller
public class ControllerGeral {
	
	@Autowired
	private CategoriaRepositorio repository;
	
	 @GetMapping("/")
	 public String index() {
		 return "index";
	 }
	 
	 @GetMapping(value="/cadastrarCurso")
	 public String form() {
		 return "formCad";
	 }
	 
	 @GetMapping(value="/curso")
	 public String curso() {
		 return "cadCurso";
	 }
	 
	 @GetMapping(value="/calendario")
	 public String calendario() {
		 return "calendario";
	 }
	 
	 @PostMapping(value="/cadastrarCurso")	
		 public String form(CategoriaModelo categoria) {
			 repository.save(categoria);
			 return "redirect:/cadastrarCurso";
	 }
	 
}
	
