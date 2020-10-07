package com.api.projetoIntegrador.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioModelo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id_usuario;

	@Column
	private String nome;

	@Column
	private String email;

	@Column
	private String senha;

	@Column
	private Long pontuacao;

	@Column
	private Integer curso_estudado;

	@Column
	private Integer curso_monitorado;

	@Column
	private Integer curso_criado;
	
	
	
	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Long pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Integer getCurso_estudado() {
		return curso_estudado;
	}

	public void setCurso_estudado(Integer curso_estudado) {
		this.curso_estudado = curso_estudado;
	}

	public Integer getCurso_monitorado() {
		return curso_monitorado;
	}

	public void setCurso_monitorado(Integer curso_monitorado) {
		this.curso_monitorado = curso_monitorado;
	}

	public Integer getCurso_criado() {
		return curso_criado;
	}

	public void setCurso_criado(Integer curso_criado) {
		this.curso_criado = curso_criado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_usuario == null) ? 0 : id_usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioModelo other = (UsuarioModelo) obj;
		if (id_usuario == null) {
			if (other.id_usuario != null)
				return false;
		} else if (!id_usuario.equals(other.id_usuario))
			return false;
		return true;
	}

}
