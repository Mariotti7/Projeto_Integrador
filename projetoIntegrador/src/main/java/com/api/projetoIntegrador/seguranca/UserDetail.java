package com.api.projetointegrador.seguranca;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.api.projetointegrador.modelo.UsuarioModelo;

public class UserDetail implements UserDetails {
	private static final long serialVersionUID = 1L;

	private String email;
	private String password;
	private Collection<GrantedAuthority> permissoes = new ArrayList<>();

	public UserDetail(UsuarioModelo user) {
		this.email = user.getEmail();
		this.password = user.getSenha();
	}

	public UserDetail() {

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return permissoes;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
