package com.api.projetoIntegrador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;		

import com.api.projetoIntegrador.modelo.ProdutoModelo;

public interface ProdutoRepositorio extends JpaRepository<ProdutoModelo, Long> {

}
