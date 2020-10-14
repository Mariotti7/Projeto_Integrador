package com.api.projetoIntegrador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.projetoIntegrador.modelo.UsuarioModelo;

public interface UsuarioRepositorio extends JpaRepository<UsuarioModelo, Long> {
	
}
