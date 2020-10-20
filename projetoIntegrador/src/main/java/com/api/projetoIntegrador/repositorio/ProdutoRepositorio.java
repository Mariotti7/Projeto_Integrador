package com.api.projetointegrador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.projetointegrador.modelo.ProdutoModelo;

public interface ProdutoRepositorio extends JpaRepository<ProdutoModelo, Long> {

}
