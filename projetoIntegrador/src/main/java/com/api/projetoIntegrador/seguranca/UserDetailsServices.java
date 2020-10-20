package com.api.projetointegrador.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.api.projetointegrador.modelo.UsuarioModelo;
import com.api.projetointegrador.repositorio.UsuarioRepositorio;

@Service
public class UserDetailsServices implements UserDetailsService{
	
	@Autowired
	private UsuarioRepositorio userRepository; 


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UsuarioModelo> user = userRepository.findByEmail(email);
		user.orElseThrow(() -> new UsernameNotFoundException(email + " not found."));
		
		return user.map(UserDetail::new).get();
	}
	
}
