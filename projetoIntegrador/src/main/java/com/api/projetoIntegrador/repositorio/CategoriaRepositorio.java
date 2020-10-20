package com.api.projetointegrador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;	

import com.api.projetointegrador.modelo.CategoriaModelo;

public interface CategoriaRepositorio extends JpaRepository<CategoriaModelo, Long> {


}
