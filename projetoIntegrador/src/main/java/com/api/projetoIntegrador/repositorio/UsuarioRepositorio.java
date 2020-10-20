package com.api.projetointegrador.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.projetointegrador.modelo.UsuarioModelo;

public interface UsuarioRepositorio extends JpaRepository<UsuarioModelo, Long> {

	Optional<UsuarioModelo> findByEmail(String email);
	
}
